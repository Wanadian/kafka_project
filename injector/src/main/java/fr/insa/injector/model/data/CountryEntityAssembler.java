package fr.insa.injector.model.data;

import fr.insa.injector.model.Country;

public class CountryEntityAssembler {
    public static CountryEntity from(Country country){
        return new CountryEntity(
                country.getCountry(),
                country.getId(),
                country.getCountryCode(),
                country.getSlug(),
                country.getNewConfirmed(),
                country.getTotalConfirmed(),
                country.getNewDeaths(),
                country.getTotalDeaths(),
                country.getNewRecovered(),
                country.getTotalRecovered(),
                country.getDate());
    }
}
