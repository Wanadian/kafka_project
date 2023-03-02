package fr.insa.api.controllers;

import fr.insa.api.models.Summary;
import fr.insa.api.services.CountryService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/{countryName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Summary getCountryValues(@PathVariable("countryName") String countryName) throws InterruptedException {
        return countryService.getCountryValues(countryName);
    }
}
