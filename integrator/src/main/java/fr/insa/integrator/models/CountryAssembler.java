package fr.insa.integrator.models;

import fr.insa.integrator.models.dto.CountryDto;

public class CountryAssembler {
    public static Country from(CountryDto countryDto) {
        return new Country(
                countryDto.id(),
                countryDto.country(),
                countryDto.countryCode(),
                countryDto.slug(),
                countryDto.newConfirmed(),
                countryDto.totalConfirmed(),
                countryDto.newDeaths(),
                countryDto.totalDeaths(),
                countryDto.newRecovered(),
                countryDto.TotalRecovered(),
                countryDto.date());
    }
}
