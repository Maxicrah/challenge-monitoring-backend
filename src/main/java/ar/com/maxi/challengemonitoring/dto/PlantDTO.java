package ar.com.maxi.challengemonitoring.dto;

import ar.com.maxi.challengemonitoring.enums.AlertType;

import jakarta.validation.constraints.*;
import lombok.*;


@AllArgsConstructor
@Getter @Setter
public class PlantDTO {
    @NotBlank(message = "country required")
    @Size(max = 20, message = "country cannot exceed 20 characters")
    private String country;
    @NotBlank(message = "name is required")
    @Size(max = 20, message = "name cannot exceed 20 characters")
    private String name;
    @NotNull(message = "quantity alert is required")
    @Min(1)
    @Max(700)
    private Integer quantityAlert;
    @NotNull(message = "alert type is required")
    private AlertType alertType;

}
