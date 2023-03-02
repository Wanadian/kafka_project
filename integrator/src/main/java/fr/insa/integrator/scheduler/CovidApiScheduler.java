package fr.insa.integrator.scheduler;

import fr.insa.integrator.client.SumaryClient;
import fr.insa.integrator.models.Summary;
import fr.insa.integrator.models.SummaryAssembler;
import fr.insa.integrator.models.dto.SummaryDto;
import fr.insa.integrator.producers.KafkaIntegrationProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CovidApiScheduler {
    private SumaryClient client;
    private KafkaIntegrationProducer kafkaIntegrationProducer;

    Logger LOGGER = LoggerFactory.getLogger(CovidApiScheduler.class);

    public CovidApiScheduler(SumaryClient client, KafkaIntegrationProducer kafkaIntegrationProducer) {
        this.client = client;
        this.kafkaIntegrationProducer = kafkaIntegrationProducer;
    }

    @Scheduled(fixedDelay = 30000, initialDelay = 5000)
    public void scheduleApiCall() {
        SummaryDto summaryDto = client.getSummary();
        if (summaryDto.message().equals("Caching in progress")){
            LOGGER.warn("[Covid-API] api currently caching data so it's impossible de get the data");
        }else{
            Summary summary = SummaryAssembler.from(summaryDto);
            kafkaIntegrationProducer.sendMessage(summary, "integration");
        }
    }
}
