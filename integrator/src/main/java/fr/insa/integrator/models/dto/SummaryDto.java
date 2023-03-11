package fr.insa.integrator.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public record SummaryDto(
        @JsonProperty("ID")
        String id,
        @JsonProperty("Message")
        String message,
        @JsonProperty("Global")
        GlobalDto global,
        @JsonProperty("Countries")
        List<CountryDto> countries,
        @JsonProperty("Date")
        Date date) {
}
