package fr.insa.api.controllers;

import fr.insa.api.services.CovidService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid")
public class CovidController {
    private CovidService covidService;

    public CovidController() {
       super();
    }

    public CovidController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("/")
    public long getGlobalValues() {
        return covidService.getGlobalValues();
    }

	@GetMapping("/{countryId}")
    public long getCountryValues(@RequestBody long countryId) {
        return covidService.getCountryValues(countryId);
    }

	@GetMapping("/confirmed")
    public long getConfirmedAverage() {
        return covidService.getGlobalAverageConfirmed();
    }

	@GetMapping("/dead")
    public long getDeathsAverage() {
        return covidService.getGlobalAverageDead();
    }

	@GetMapping("/lethality")
    public long getCountriesDeathsPercent() {
        return covidService.getGlobalLethality();
    }

	@GetMapping("/help")
    public String getHelp() {
		return covidService.getCommands();
    }
}
