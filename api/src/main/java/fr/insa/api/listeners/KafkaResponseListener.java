package fr.insa.api.listeners;

import fr.insa.api.events.SummaryConsumerEvent;
import fr.insa.api.models.Summary;
import fr.insa.api.producers.KafkaRequestProducer;
import fr.insa.api.services.CountryService;
import fr.insa.api.services.GlobalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaResponseListener {

    private ApplicationEventPublisher applicationEventPublisher;
    private GlobalService globalService;
    private CountryService countryService;
    private KafkaRequestProducer kafkaResponseProducer;
    Logger logger = LoggerFactory.getLogger(KafkaResponseListener.class);

    public KafkaResponseListener(GlobalService globalService, CountryService countryService, KafkaRequestProducer kafkaResponseProducer, ApplicationEventPublisher applicationEventPublisher) {
        this.globalService = globalService;
        this.countryService = countryService;
        this.kafkaResponseProducer = kafkaResponseProducer;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @KafkaListener(
            topics = "response",
            groupId = "api",
            containerFactory = "responseKafkaListenerFactory"
    )
    public void listener(Summary summary){
        logger.info("[Kafka Listener] a message was received from KafKa response Topic");
        SummaryConsumerEvent summaryConsumerEvent = new SummaryConsumerEvent(this, summary);
        applicationEventPublisher.publishEvent(summaryConsumerEvent);
        System.out.println("message received");
    }
}
