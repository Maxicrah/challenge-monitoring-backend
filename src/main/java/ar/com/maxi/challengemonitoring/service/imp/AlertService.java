package ar.com.maxi.challengemonitoring.service.imp;

import ar.com.maxi.challengemonitoring.enums.AlertType;
import ar.com.maxi.challengemonitoring.model.Alert;
import ar.com.maxi.challengemonitoring.repository.IAlertRepository;
import ar.com.maxi.challengemonitoring.service.IAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService implements IAlertService {

    private final IAlertRepository alertRepository;
    public AlertService(IAlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }


    @Override
    public List<Alert> obtainHighAlerts() {
        return this.alertRepository.findAlertByType(AlertType.HIGH_ALERT);
    }

    @Override
    public List<Alert> obtainMediumAlerts() {
        return this.alertRepository.findAlertByType(AlertType.MEDIUM_ALERT);
    }

    @Override
    public List<Alert> obtainReadingsOk() {
        return this.alertRepository.findAlertByType(AlertType.READINGS_OK);
    }

    @Override
    public List<Alert> obtainSensorsDisabled() {
        return this.alertRepository.findAlertByType(AlertType.SENSORS_DISABLED);
    }

    @Override
    public Long countHighAlerts() {
        return this.alertRepository.countByAlertType(AlertType.HIGH_ALERT);
    }

    @Override
    public Long countMediumAlerts() {
        return this.alertRepository.countByAlertType(AlertType.MEDIUM_ALERT);
    }

    @Override
    public Long countReadingsOk() {
        return this.alertRepository.countByAlertType(AlertType.READINGS_OK);
    }

    @Override
    public Long countSensorsDisabled() {
        return this.alertRepository.countByAlertType(AlertType.SENSORS_DISABLED);
    }
}
