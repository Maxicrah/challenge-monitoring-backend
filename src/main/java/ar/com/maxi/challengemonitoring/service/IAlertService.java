package ar.com.maxi.challengemonitoring.service;

import ar.com.maxi.challengemonitoring.model.Alert;

import java.util.List;

public interface IAlertService {

    List<Alert> obtainHighAlerts();
    List<Alert> obtainMediumAlerts();
    List<Alert> obtainReadingsOk();
    List<Alert> obtainSensorsDisabled();
    Long countHighAlerts();
    Long countMediumAlerts();
    Long countReadingsOk();
    Long countSensorsDisabled();

}
