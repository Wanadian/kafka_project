package fr.insa.api.services;

import fr.insa.api.repositories.CovidRepository;
import fr.insa.api.utils.Commands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidService {
    @Autowired
    CovidRepository covidRepository;
    
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
