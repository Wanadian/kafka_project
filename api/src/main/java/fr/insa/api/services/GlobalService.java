package fr.insa.api.services;

import fr.insa.api.models.Global;
import fr.insa.api.models.Summary;
import org.springframework.stereotype.Service;

@Service
public class GlobalService {
    private KafkaService kafkaService;

    public GlobalService(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    public Global getGlobalValues() throws InterruptedException {
        return kafkaService.requestData().getGlobal();
    }

    public Summary xmlExport() throws InterruptedException {
        return kafkaService.requestData();
    }
}
