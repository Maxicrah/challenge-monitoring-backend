package ar.com.maxi.challengemonitoring.controller;

import ar.com.maxi.challengemonitoring.dto.PlantDTO;
import ar.com.maxi.challengemonitoring.model.Plant;
import ar.com.maxi.challengemonitoring.service.imp.PlantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/plant")
public class PlantController {

    private final PlantService plantService;
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Plant>> createPlant(@Valid @RequestBody PlantDTO plantDto){
      Plant plant = this.plantService.createPlant(plantDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "plant", plant
        ));
    }

}
