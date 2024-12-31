package ar.com.maxi.challengemonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ChallengeMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeMonitoringApplication.class, args);
    }

}
