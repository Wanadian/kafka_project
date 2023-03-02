package fr.insa.api.controllers;

import fr.insa.api.services.CountryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private CountryService countryService;

    @Value("${spring.kafka.consumer.topic-name}")
    private String topic;

    public CountryController() {
        super();
    }

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/{countryName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long getCountryValues(@RequestBody String countryName) {
        return countryService.getCountryValues(countryName);
    }
}
