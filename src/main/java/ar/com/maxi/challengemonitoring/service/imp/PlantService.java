package ar.com.maxi.challengemonitoring.service.imp;

import ar.com.maxi.challengemonitoring.dto.PlantDTO;
import ar.com.maxi.challengemonitoring.model.Alert;
import ar.com.maxi.challengemonitoring.model.Plant;
import ar.com.maxi.challengemonitoring.repository.IAlertRepository;
import ar.com.maxi.challengemonitoring.repository.IPlantRepository;
import ar.com.maxi.challengemonitoring.service.IPlantService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantService implements IPlantService {

    private final IPlantRepository plantRepository;
    private final IAlertRepository alertRepository;
    public PlantService(IPlantRepository plantRepository, IAlertRepository alertRepository) {
        this.plantRepository = plantRepository;
        this.alertRepository = alertRepository;
    }

    @Transactional
    @Override
    public Plant createPlant(PlantDTO plantDto) {
        Plant plant = new Plant();
        plant.setName(plantDto.getName());
        plant.setCountry(plantDto.getCountry());

        if(plantDto.getQuantityAlert()== null && plantDto.getAlertType() == null){
            throw new RuntimeException("Invalid");
        }

        Alert alert = new Alert();
        alert.setQuantity(plantDto.getQuantityAlert());
        alert.setAlertType(plantDto.getAlertType());
        alert.setPlant(plant);
        this.alertRepository.save(alert);
        if (plant.getAlerts() == null) {
            plant.setAlerts(new ArrayList<>());
        }
        plant.getAlerts().add(alert);

        return this.plantRepository.save(plant);
    }

    @Override
    public Plant findPlantById(Long id) {
        return this.plantRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deletePlantById(Long id) {
        Plant plant = this.findPlantById(id);
        this.alertRepository.deleteAll(plant.getAlerts());
        this.plantRepository.delete(plant);
    }

    @Override
    public List<Plant> findAllPlants() {
        return this.plantRepository.findAll();
    }

    @Transactional
    @Override
    public Plant updatePlantById(PlantDTO plantDto, Long id) {
        Plant existingPlant = this.findPlantById(id);
        boolean alertUpdated = false;
        if (existingPlant == null) {
            throw new RuntimeException("plant not found with id: " + id);
        }
        List<Alert> alerts = existingPlant.getAlerts();

        if(alerts == null || alerts.isEmpty()){
            throw new RuntimeException("alerts empty");
        }

        for (Alert alert : alerts) {
            if (alert.getAlertType() == plantDto.getAlertType()) {
                alert.setQuantity(plantDto.getQuantityAlert());
                alertUpdated = true;
                break;
            }
        }

        if(!alertUpdated){
            throw new RuntimeException("alerts not found");
        }
        //code para añadir alerta
//        if (!alertUpdated) {
//            Alert newAlert = new Alert();
//            newAlert.setQuantity(plantDto.getQuantityAlert());
//            newAlert.setAlertType(plantDto.getAlertType());
//            newAlert.setPlant(existingPlant);
//            this.alertRepository.save(newAlert);
//
//            if (existingPlant.getAlerts() == null) {
//                existingPlant.setAlerts(new ArrayList<>());
//            }
//            existingPlant.getAlerts().add(newAlert);
//        }

        return this.plantRepository.save(existingPlant);
    }

}
