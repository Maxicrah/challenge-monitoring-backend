package ar.com.maxi.challengemonitoring.service.imp;

import ar.com.maxi.challengemonitoring.dto.Country;
import ar.com.maxi.challengemonitoring.service.IRestCountryAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryApiService {

    private final IRestCountryAPI restCountryAPI;

    @Value("${country.key}")
    private String apiKey;
    
    public CountryApiService(IRestCountryAPI restCountryAPI) {
        this.restCountryAPI = restCountryAPI;
    }


    public List<Country> getCountries() {
        return this.restCountryAPI.getCountries(apiKey);
    }
    

}
