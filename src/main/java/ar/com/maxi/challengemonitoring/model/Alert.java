package ar.com.maxi.challengemonitoring.model;

import ar.com.maxi.challengemonitoring.enums.AlertType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private AlertType alertType;
    @ManyToOne
    @JoinColumn(name = "id_plant")
    private Plant plant;
}
