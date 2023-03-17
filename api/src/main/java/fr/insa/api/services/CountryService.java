package fr.insa.api.services;

import fr.insa.api.models.Country;
import fr.insa.api.models.Summary;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private KafkaService kafkaService;

    public CountryService(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    public List<String> getCountries() throws InterruptedException {
        Summary summary = kafkaService.requestData();
        return summary.getCountries().stream().map(Country::getCountry).collect(Collectors.toList());
    }

    public Country getCountryValues(String countryName) throws InterruptedException {
        Summary summary = kafkaService.requestData();
        return summary.getCountries().stream().filter(country -> country.getCountry().equals(countryName)).findFirst().orElseThrow(RuntimeException::new);
    }

    public double getConfirmedAverage() throws InterruptedException {
        Summary summary = kafkaService.requestData();
        return summary.getCountries().stream().mapToDouble(Country::getTotalConfirmed).average().orElse(0);
    }

    public double getGlobalAverageDead() throws InterruptedException {
        Summary summary = kafkaService.requestData();
        return summary.getCountries().stream().mapToDouble(Country::getTotalDeaths).average().orElse(0);
    }

    public double getGlobalLethality() throws InterruptedException {
        Summary summary = kafkaService.requestData();
        double confirmed = summary.getCountries().stream().mapToDouble(Country::getTotalConfirmed).sum();
        double deaths = summary.getCountries().stream().mapToDouble(Country::getTotalDeaths).sum();
        return (deaths/confirmed)*100;
    }
}
