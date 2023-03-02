package fr.insa.api.services;

import fr.insa.api.events.SummaryConsumerEvent;
import fr.insa.api.models.Summary;
import fr.insa.api.producers.KafkaRequestProducer;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class CountryService {

    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private Summary dataEvent;
    private KafkaTemplate kafkaTemplate;
    private KafkaRequestProducer kafkaRequestProducer;

    public CountryService(KafkaTemplate kafkaTemplate, KafkaRequestProducer kafkaRequestProducer) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaRequestProducer = kafkaRequestProducer;
    }

    public Summary getCountryValues(String countryName) throws InterruptedException {
        kafkaRequestProducer.sendMessage(String.format("get country values of %s", countryName), "request");
        //on attend que l'event soit déclenché dans le consumer
        countDownLatch.await();
        return this.dataEvent;
    }

    @EventListener
    public void handleSummaryConsumerEvent(SummaryConsumerEvent summaryConsumerEvent){
        this.dataEvent = summaryConsumerEvent.getSummary();
        this.countDownLatch.countDown();
    }
}
