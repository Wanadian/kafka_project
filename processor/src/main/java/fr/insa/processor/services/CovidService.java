package fr.insa.processor.services;

import fr.insa.processor.repositories.CovidRepository;
import fr.insa.processor.utils.Commands;
import org.springframework.stereotype.Service;

@Service
public class CovidService {
    private CovidRepository covidRepository;

    public CovidService() {
        super();
    }

    public CovidService(CovidRepository covidRepository) {
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
