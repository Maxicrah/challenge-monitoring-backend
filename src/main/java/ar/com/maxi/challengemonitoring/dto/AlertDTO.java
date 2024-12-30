package ar.com.maxi.challengemonitoring.dto;

import ar.com.maxi.challengemonitoring.enums.AlertType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertDTO {
    @NotNull(message = "alert type is required")
    private AlertType alertType;
    @NotNull(message = "quantity alert is required")
    @Min(1)
    @Max(1000)
    private Integer quantityAlert;
}
