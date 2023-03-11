package fr.insa.api.controllers;

import fr.insa.api.models.Commands;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/help")
public class HelpController {

    public HelpController() {
        super();
    }

    @GetMapping(value = "/")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String getHelp() {
        return new Commands().getCommands();
    }
}
