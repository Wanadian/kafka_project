package fr.insa.api.controllers;

import fr.insa.api.models.Country;
import fr.insa.api.services.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<String> getCountries() throws InterruptedException {
        return countryService.getCountries();
    }

    @GetMapping(value = "/{countryName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Country getCountryValues(@PathVariable("countryName") String countryName) throws InterruptedException {
        return countryService.getCountryValues(countryName);
    }

    @GetMapping(value = "/confirmed_avg", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public double getConfirmedAverage() throws InterruptedException {
        return countryService.getConfirmedAverage();
    }

    @GetMapping(value = "/deaths_avg", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public double getDeathsAverage() throws InterruptedException {
        return countryService.getGlobalAverageDead();
    }

    @GetMapping(value = "/lethality", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public double getDeathsPercent() throws InterruptedException {
        return countryService.getGlobalLethality();
    }
}
