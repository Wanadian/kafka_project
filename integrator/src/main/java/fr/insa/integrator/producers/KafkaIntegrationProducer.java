package fr.insa.integrator.producers;

import fr.insa.integrator.models.Summary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaIntegrationProducer {

    private KafkaTemplate<String, Summary> kafkaIntegrationTemplate;

    public KafkaIntegrationProducer(KafkaTemplate<String, Summary> kafkaIntegrationTemplate) {
        this.kafkaIntegrationTemplate = kafkaIntegrationTemplate;
    }

    public void sendMessage(Summary summary, String topicName) {
        kafkaIntegrationTemplate.send(topicName, summary);
    }
}
