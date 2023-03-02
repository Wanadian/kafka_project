package fr.insa.api.services;

import fr.insa.api.listeners.KafkaResponseListener;
import fr.insa.api.models.Country;
import fr.insa.api.models.Summary;
import fr.insa.api.producers.KafkaRequestProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    private KafkaTemplate kafkaTemplate;
    private KafkaRequestProducer kafkaRequestProducer;

    public CountryService(KafkaTemplate kafkaTemplate, KafkaRequestProducer kafkaRequestProducer) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaRequestProducer = kafkaRequestProducer;
    }

    public void getCountryValues(String countryName) {
        kafkaRequestProducer.sendMessage(String.format("get country values of %s", countryName), "request");
    }
}
