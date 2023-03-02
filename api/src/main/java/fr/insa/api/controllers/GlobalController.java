package fr.insa.api.controllers;

import fr.insa.api.services.GlobalService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/global")
public class GlobalController {

    private GlobalService globalService;

    public GlobalController() {
        super();
    }

    public GlobalController(GlobalService globalService) {
        this.globalService = globalService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long getGlobalValues() {
        return 0/*globalService.getGlobalValues()*/;
    }

    @GetMapping(value = "/confirmed", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long getConfirmedAverage() {
        return 0/*;globalService.getGlobalAverageConfirmed()*/;
    }

    @GetMapping(value = "/dead", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long getDeathsAverage() {
        return 0/*globalService.getGlobalAverageDead()*/;
    }

    @GetMapping(value = "/lethality", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long getCountriesDeathsPercent() {
        return 0/*globalService.getGlobalLethality()*/;
    }
}
