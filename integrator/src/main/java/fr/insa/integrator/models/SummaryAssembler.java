package fr.insa.integrator.models;

import fr.insa.integrator.models.dto.SummaryDto;

public class SummaryAssembler {
    public static Summary from(SummaryDto summaryDto){
        return new Summary(
                summaryDto.id(),
                GlobalAssembler.from(summaryDto.global()),
                summaryDto.countries().stream().map(CountryAssembler::from).toList(),
                summaryDto.date()
        );
    }
}
