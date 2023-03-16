package fr.insa.api.controllers;

import fr.insa.api.models.Global;
import fr.insa.api.models.Summary;
import fr.insa.api.services.GlobalService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/global")
public class GlobalController {

    private GlobalService globalService;

    public GlobalController(GlobalService globalService) {
        this.globalService = globalService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Global getGlobalValues() throws InterruptedException {
        return globalService.getGlobalValues();
    }

    @GetMapping(value = "/export", produces = MediaType.APPLICATION_XML_VALUE)
    public Summary xmlExport() throws InterruptedException {
        return globalService.xmlExport();
    }
}
