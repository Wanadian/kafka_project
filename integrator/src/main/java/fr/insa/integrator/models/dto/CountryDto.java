package fr.insa.integrator.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record CountryDto(
        @JsonProperty("ID")
        String id,
        @JsonProperty("Country")
        String country,
        @JsonProperty("CountryCode")
        String countryCode,
        @JsonProperty("Slug")
        String slug,
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
        int TotalRecovered,
        @JsonProperty("Date")
        Date date) {
}
