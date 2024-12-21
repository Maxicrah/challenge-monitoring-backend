package ar.com.maxi.challengemonitoring.repository;

import ar.com.maxi.challengemonitoring.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlertRepository extends JpaRepository<Alert, Long> {
}
