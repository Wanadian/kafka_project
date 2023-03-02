package fr.insa.api.listeners;

import fr.insa.api.models.Summary;
import fr.insa.api.producers.KafkaRequestProducer;
import fr.insa.api.services.CountryService;
import fr.insa.api.services.GlobalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class KafkaResponseListener {

    private GlobalService globalService;
    private CountryService countryService;
    private KafkaRequestProducer kafkaResponseProducer;
    Logger logger = LoggerFactory.getLogger(KafkaResponseListener.class);

    public KafkaResponseListener(GlobalService globalService, CountryService countryService, KafkaRequestProducer kafkaResponseProducer) {
        this.globalService = globalService;
        this.countryService = countryService;
        this.kafkaResponseProducer = kafkaResponseProducer;
    }

    @KafkaListener(
            topics = "response",
            groupId = "api",
            containerFactory = "responseKafkaListenerFactory"
    )
    public Summary listener(Summary summary){
        logger.info("[Kafka Listener] a message was received from KafKa response Topic");
        System.out.println("message received");
    }
}
