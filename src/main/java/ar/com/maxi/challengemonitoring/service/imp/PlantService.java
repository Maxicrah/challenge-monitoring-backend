package ar.com.maxi.challengemonitoring.service.imp;

import ar.com.maxi.challengemonitoring.dto.AlertDTO;
import ar.com.maxi.challengemonitoring.dto.PlantDTO;
import ar.com.maxi.challengemonitoring.enums.AlertType;
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
        List<Alert> alerts = new ArrayList<>();

        for (AlertType alertType : AlertType.values()) {
            Alert alert = new Alert();
            alert.setQuantity(0);
            alert.setAlertType(alertType);
            alert.setPlant(plant);
            alerts.add(alert);
        }
        this.alertRepository.saveAll(alerts);

        plant.setAlerts(alerts);

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
    public Plant updateQuantityAlertsForPlantById(Long id, List<AlertDTO> alerts){
        Plant plant = this.findPlantById(id);

        if (plant == null) {
            throw new RuntimeException("plant not found with id: " + id);
        }

        List<Alert> plantAlerts = plant.getAlerts();

        if (plantAlerts == null || plantAlerts.isEmpty()) {
            throw new RuntimeException("no alerts found for plant with id: " + id);
        }
        for (Alert alert : plantAlerts) {
            for (AlertDTO alertDto : alerts) {
                if (alert.getAlertType() == alertDto.getAlertType()) {
                    alert.setQuantity(alertDto.getQuantityAlert());
                }
            }
        }
        return this.plantRepository.save(plant);
    }

}
