package fr.insa.integrator.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record GlobalDto(
        @JsonProperty("NewConfirmed")
        int newConfirmed,
        @JsonProperty("TotalConfirmed")
        int totalConfirmed,
        @JsonProperty("NewDeaths")
        int newDeaths,
        @JsonProperty("TotalDeaths")
        int totalDeaths,
        @JsonProperty("NewRecovered")
        int newRecovered,
        @JsonProperty("TotalRecovered")
        int totalRecovered,
        @JsonProperty("Date")
        Date date) {
}
