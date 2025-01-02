package ar.com.maxi.challengemonitoring.controller;

import ar.com.maxi.challengemonitoring.dto.Country;
import ar.com.maxi.challengemonitoring.service.imp.CountryApiService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://monitoring-challenge.vercel.app")
public class CountryController {

    private final CountryApiService countryApiService;
    public CountryController(CountryApiService countryApiService) {
        this.countryApiService = countryApiService;
    }
    @GetMapping("/countries")
    public List<Country> getCountries() {
        return this.countryApiService.getCountries();
    }

}
