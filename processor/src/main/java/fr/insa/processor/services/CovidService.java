package fr.insa.processor.services;

import fr.insa.processor.repositories.GlobalRepository;
import fr.insa.processor.models.Commands;
import org.springframework.stereotype.Service;

@Service
public class CovidService {
    private GlobalRepository covidRepository;

    public CovidService() {
        super();
    }

    public CovidService(GlobalRepository covidRepository) {
        this.covidRepository = covidRepository;
    }

    public String getCommands(){
        return new Commands().getCommands();
    }

    public long getGlobalValues(){
        return 1;
    }

    public long getCountryValues(long countryId){
        return 1;
    }

    public long getGlobalAverageConfirmed(){
        return 1;
    }

    public long getGlobalAverageDead(){
        return 1;
    }

    public long getGlobalLethality(){
        return 1;
    }
}
