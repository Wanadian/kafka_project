package fr.insa.processor.listeners;

import fr.insa.processor.models.Summary;
import fr.insa.processor.producers.KafkaResponseProducer;
import fr.insa.processor.repositories.CountryRepository;
import fr.insa.processor.repositories.GlobalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaRequestListener {
    private GlobalRepository globalRepository;
    private CountryRepository countryRepository;
    private KafkaResponseProducer kafkaResponseProducer;
    Logger logger = LoggerFactory.getLogger(KafkaRequestListener.class);

    public KafkaRequestListener(GlobalRepository globalRepository, CountryRepository countryRepository, KafkaResponseProducer kafkaResponseProducer) {
        this.globalRepository = globalRepository;
        this.countryRepository = countryRepository;
        this.kafkaResponseProducer = kafkaResponseProducer;
    }

    @KafkaListener(
            topics = "request",
            groupId = "processor",
            containerFactory = "requestKafkaListenerFactory"
    )
    public void listener(Summary summary){
        logger.info("[Kafka Listener] a message was received from KafKa request Topic");
        System.out.println("message received");
        //summary.setGlobal(globalRepository.findFirstByOrderByDateAsc());
        summary.setCountries(countryRepository.findAll());
        kafkaResponseProducer.sendMessage(summary, "response");
    }
}
