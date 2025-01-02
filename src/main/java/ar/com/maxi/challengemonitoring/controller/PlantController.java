package ar.com.maxi.challengemonitoring.controller;

import ar.com.maxi.challengemonitoring.dto.AlertDTO;
import ar.com.maxi.challengemonitoring.dto.PlantDTO;
import ar.com.maxi.challengemonitoring.model.Plant;
import ar.com.maxi.challengemonitoring.service.imp.PlantService;
import feign.Response;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plant")
@CrossOrigin (origins = {"https://monitoring-challenge-2y0ww4n79-maximilianos-projects-a55ff8fb.vercel.app"})
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Plant>> createPlant(@Valid @RequestBody PlantDTO plantDto) {
        Plant plant = this.plantService.createPlant(plantDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "plant", plant
        ));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Map<String, Plant>> findPlant(@PathVariable(name = "id") Long id) {
        Plant plant = this.plantService.findPlantById(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "plant", plant
        ));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Plant>> findAllPlant() {
        List<Plant> plants = this.plantService.findAllPlants();
        return ResponseEntity.status(HttpStatus.OK).body(plants);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlant(@PathVariable("id") Long id) {
        this.plantService.deletePlantById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("plant with id " + id + " was deleted");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Map<String, Plant>> editPlant(@PathVariable(name = "id") Long id,
                                                        @Valid @RequestBody List<AlertDTO> alerts
                                                        ) {

        Plant plant = this.plantService.updateQuantityAlertsForPlantById(id, alerts);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Map.of(
                "plant updated", plant
        ));
    }

}
