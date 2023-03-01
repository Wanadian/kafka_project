package fr.insa.integrator.client;

import fr.insa.integrator.models.dto.SummaryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(url = "https://api.covid19api.com/", name = "COVID-API")
public interface SumaryClient {
    @GetMapping(value = "/summary", consumes = "application/json")
    SummaryDto getSummary();
}
