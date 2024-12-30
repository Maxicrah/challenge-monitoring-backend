package ar.com.maxi.challengemonitoring.repository;


import ar.com.maxi.challengemonitoring.enums.AlertType;
import ar.com.maxi.challengemonitoring.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface IAlertRepository extends JpaRepository<Alert, Long> {

    @Query("SELECT a FROM Alert a WHERE a.alertType = :type")
    List<Alert> findAlertByType(AlertType type);

    @Query("SELECT SUM(a.quantity) FROM Alert a WHERE a.alertType = :type")
    Long countByAlertType(AlertType type);

}
