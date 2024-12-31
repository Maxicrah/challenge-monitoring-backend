package ar.com.maxi.challengemonitoring.service;

import ar.com.maxi.challengemonitoring.dto.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "rest-country-api", url = "https://rest-countries10.p.rapidapi.com")
public interface IRestCountryAPI {

    @GetMapping("/countries")
    List<Country> getCountries (@RequestHeader("x-rapidapi-key") String apiKey);

}
