package fr.insa.processor.producers;

import fr.insa.processor.models.Summary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaResponseProducer {

    private KafkaTemplate<String, Summary> kafkaResponseTemplate;

    public KafkaResponseProducer(KafkaTemplate<String, Summary> kafkaResponseTemplate) {
        this.kafkaResponseTemplate = kafkaResponseTemplate;
    }

    public void sendMessage(Summary summary, String topicName) {
        kafkaResponseTemplate.send(topicName, summary);
    }
}
