package ar.com.maxi.challengemonitoring.dto;

import ar.com.maxi.challengemonitoring.enums.AlertType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@AllArgsConstructor
@Getter @Setter
public class PlantDTO {
    @NotBlank(message = "country required")
    private String country;
    @NotBlank(message = "name is required")
    private String name;
    @NotNull
    private Integer quantityAlert;
    @NotNull
    private AlertType alertType;



}
