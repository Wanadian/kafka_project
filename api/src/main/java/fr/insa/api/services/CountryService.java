package fr.insa.api.services;

import fr.insa.api.events.SummaryConsumerEvent;
import fr.insa.api.models.Country;
import fr.insa.api.models.Summary;
import fr.insa.api.producers.KafkaRequestProducer;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.concurrent.CountDownLatch;

@Service
public class CountryService {

    private KafkaService kafkaService;

    public CountryService(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
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
