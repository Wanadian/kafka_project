package fr.insa.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insa.api.models.CountryStatistics;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrationService {
    private CovidService covidService;

    public IntegrationService() {
        super();
    }

    public IntegrationService(CovidService covidService) {
        this.covidService = covidService;
    }

    /**
     * Mapping JSON => Entities & Intégration en base
     * @param message 
     * @param topic 
     */
    public void integrateMessage(String message, String topic) throws JSONException {
        
        JSONObject jsonMessage = new JSONObject(message);
        
        CountryStatistics countryStatistics;

            try {
                //init & read mapper
                ObjectMapper mvtMapper = new ObjectMapper();
                countryStatistics= mvtMapper.readValue(jsonMessage.toString(), CountryStatistics.class);
                  
                covidService.save(countryStatistics);
            } catch (JsonProcessingException ex) {
                //ex.printStackTrace();
             }
    }
    
}
