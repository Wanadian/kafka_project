package fr.insa.injector.model.data;

import fr.insa.injector.model.Global;

public class GlobalEntityAssembler {
    public static GlobalEntity from(Global global){
        return new GlobalEntity(
                global.getNewConfirmed(),
                global.getTotalConfirmed(),
                global.getNewDeaths(),
                global.getTotalDeaths(),
                global.getNewRecovered(),
                global.getTotalRecovered(),
                global.getDate()
        );
    }
}
