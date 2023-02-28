package fr.insa.api.controllers;

import fr.insa.api.services.CovidService;
import fr.insa.api.services.IntegrationService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/covid")
public class CovidController {
    private IntegrationService integrationService;

    private CovidService covidService;

    @Value("${spring.kafka.consumer.topic-name}")
    private String topic;

    public CovidController() {
        super();
    }

    public CovidController(CovidService covidService, IntegrationService integrationService) {
        this.covidService = covidService;
        this.integrationService = integrationService;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic-name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) throws JSONException {
        integrationService.integrateMessage(message, topic);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long getGlobalValues() {
        return covidService.getGlobalValues();
    }

	@GetMapping(value = "/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long getCountryValues(@RequestBody long countryId) {
        return covidService.getCountryValues(countryId);
    }

	@GetMapping(value = "/confirmed", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long getConfirmedAverage() {
        return covidService.getGlobalAverageConfirmed();
    }

	@GetMapping(value = "/dead", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long getDeathsAverage() {
        return covidService.getGlobalAverageDead();
    }

	@GetMapping(value = "/lethality", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long getCountriesDeathsPercent() {
        return covidService.getGlobalLethality();
    }

	@GetMapping(value = "/help", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String getHelp() {
		return covidService.getCommands();
    }
}
