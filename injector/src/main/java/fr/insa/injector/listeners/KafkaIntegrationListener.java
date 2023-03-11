package fr.insa.injector.listeners;

import fr.insa.injector.model.Summary;
import fr.insa.injector.model.data.CountryEntity;
import fr.insa.injector.model.data.CountryEntityAssembler;
import fr.insa.injector.model.data.GlobalEntity;
import fr.insa.injector.model.data.GlobalEntityAssembler;
import fr.insa.injector.repositories.CountryRepository;
import fr.insa.injector.repositories.GlobalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaIntegrationListener {
    private GlobalRepository globalRepository;
    private CountryRepository countryRepository;
    Logger logger = LoggerFactory.getLogger(KafkaIntegrationListener.class);

    public KafkaIntegrationListener(GlobalRepository globalRepository, CountryRepository countryRepository) {
        this.globalRepository = globalRepository;
        this.countryRepository = countryRepository;
    }

    @KafkaListener(
            topics = "integration",
            groupId = "injector",
            containerFactory = "integrationKafkaListenerFactory"
    )
    public void listener(Summary summary){
        logger.info("[Kafka Listener] a message was received from KafKa integration Topic");
        GlobalEntity global = GlobalEntityAssembler.from(summary.getGlobal());
        List<CountryEntity> countries = summary.getCountries().stream().map(CountryEntityAssembler::from).toList();
        globalRepository.save(global);
        countryRepository.saveAll(countries);
    }
}
