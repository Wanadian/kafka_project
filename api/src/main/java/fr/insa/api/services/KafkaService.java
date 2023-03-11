package fr.insa.api.services;

import fr.insa.api.events.SummaryConsumerEvent;
import fr.insa.api.models.Summary;
import fr.insa.api.producers.KafkaRequestProducer;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class KafkaService {
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private Summary dataEvent;
    private KafkaRequestProducer kafkaRequestProducer;

    public KafkaService(KafkaRequestProducer kafkaRequestProducer) {
        this.kafkaRequestProducer = kafkaRequestProducer;
    }

    public Summary requestData() throws InterruptedException {
        kafkaRequestProducer.sendMessage("request Data from processor", "request");
        //wait event triggered
        countDownLatch.await();
        return this.dataEvent;
    }

    @EventListener
    public void handleSummaryConsumerEvent(SummaryConsumerEvent summaryConsumerEvent){
        this.dataEvent = summaryConsumerEvent.getSummary();
        this.countDownLatch.countDown();
    }
}
