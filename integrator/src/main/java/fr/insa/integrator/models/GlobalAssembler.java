package fr.insa.integrator.models;

import fr.insa.integrator.models.dto.GlobalDto;

public class GlobalAssembler {
    public static Global from(GlobalDto globalDto){
        return new Global(
                globalDto.newConfirmed(),
                globalDto.totalConfirmed(),
                globalDto.newDeaths(),
                globalDto.totalDeaths(),
                globalDto.newRecovered(),
                globalDto.totalRecovered(),
                globalDto.date()
        );
    }
}
