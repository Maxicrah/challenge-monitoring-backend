package ar.com.maxi.challengemonitoring.controller;

import ar.com.maxi.challengemonitoring.model.Alert;
import ar.com.maxi.challengemonitoring.service.IAlertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alert")
@CrossOrigin(origins = {"https://monitoring-challenge.vercel.app"})
public class AlertController {

    private final IAlertService alertService;
    public AlertController(IAlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping("/high")
    public ResponseEntity<List<Alert>> getHighAlerts() {
        List<Alert> listHighAlerts = this.alertService.obtainHighAlerts();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(listHighAlerts);
    }

    @GetMapping("/medium")
    public ResponseEntity<List<Alert>> getMediumAlerts() {
        List<Alert> listMediumAlerts = this.alertService.obtainMediumAlerts();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(listMediumAlerts);
    }
    @GetMapping("/reading-ok")
    public ResponseEntity<List<Alert>> getReadingsOkAlerts() {
        List<Alert> listReadingsOk = this.alertService.obtainReadingsOk();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(listReadingsOk);
    }
    @GetMapping("/sensors-disabled")
    public ResponseEntity<List<Alert>> getSensorsDisabledAlerts() {
        List<Alert> listSensorsDisabledAlerts = this.alertService.obtainSensorsDisabled();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(listSensorsDisabledAlerts);
    }


    @GetMapping("/count/high")
    public ResponseEntity<Long> getCountHighAlerts() {
        Long highAlerts = this.alertService.countHighAlerts();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                highAlerts
        );
    }

    @GetMapping("/count/medium")
    public ResponseEntity<Long> getCountMediumAlerts() {
        Long mediumAlerts = this.alertService.countMediumAlerts();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                mediumAlerts
        );
    }

    @GetMapping("/count/reading-ok")
    public ResponseEntity<Long> getCountReadingsOkAlerts() {
        Long readingsOk = this.alertService.countReadingsOk();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                 readingsOk
        );
    }

    @GetMapping("/count/sensors-disabled")
    public ResponseEntity<Long> getCountSensorsDisabledAlerts() {
        Long sensorsDisabledAlerts = this.alertService.countSensorsDisabled();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                sensorsDisabledAlerts
        );
    }

}
