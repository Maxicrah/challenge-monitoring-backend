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

    @Override
    public void deletePlantById(Long id) {
        if(plantRepository.existsById(id)){
            this.plantRepository.deleteById(id);
        }else{
            throw new RuntimeException("Plant not found");
        }
    }

    @Override
    public List<Plant> findAllPlants() {
        return this.plantRepository.findAll();
    }

    @Override
    public PlantDTO updatePlantById(PlantDTO plant, Long id) {
        return null;
    }
}
