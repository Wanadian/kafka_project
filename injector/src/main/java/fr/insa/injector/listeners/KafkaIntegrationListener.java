package fr.insa.injector.listeners;

import fr.insa.injector.model.Summary;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaIntegrationListener {

    @KafkaListener(
            topics = "integration",
            groupId = "injector",
            containerFactory = "integrationKafkaListenerFactory"
    )
    public void listener(Summary summary){
        System.out.println("message received");
        System.out.println(summary);
    }
}
