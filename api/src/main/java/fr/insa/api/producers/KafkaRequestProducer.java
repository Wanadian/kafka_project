package fr.insa.api.producers;

import fr.insa.api.models.Summary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaRequestProducer {

    private KafkaTemplate<String, String> kafkaRequestTemplate;

    public KafkaRequestProducer(KafkaTemplate<String, String> kafkaRequestTemplate) {
        this.kafkaRequestTemplate = kafkaRequestTemplate;
    }

    public void sendMessage(String message, String topicName) {
        kafkaRequestTemplate.send(topicName, message);
    }
}
