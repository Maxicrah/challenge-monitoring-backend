package ar.com.maxi.challengemonitoring.service;

import ar.com.maxi.challengemonitoring.dto.PlantDTO;
import ar.com.maxi.challengemonitoring.model.Plant;

import java.util.List;

public interface IPlantService {

    Plant createPlant(PlantDTO plantDto);
    Plant findPlantById(Long id);
    void deletePlantById(Long id);
    List<Plant> findAllPlants();
    Plant updatePlantById(PlantDTO plant, Long id);

}
