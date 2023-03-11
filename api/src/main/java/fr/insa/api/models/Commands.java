package fr.insa.api.models;

public class Commands {
    public Commands(){
        super();
    }

    public String getCommands(){
        return "Commands :\n-global/export\n-global\n-countries/{countryName}\n-countries/lethality\n-countries/deaths-avg\n-countries/confirmed_avg";
    }
}
