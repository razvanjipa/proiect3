package com.project3v3.flightsearch.models;

import java.util.HashMap;

public final class IcaoCodes {
    private HashMap<String,String> airports = new HashMap<String, String>();
    public void initialize(){
        airports.put("Tel Aviv Yafo","LLBG");
        airports.put("Vienna", "LOWW");
        airports.put("Lisbon", "LPPT");
        airports.put("Luxembourg", "ELLX");
        airports.put("Milan", "LIMC");
        airports.put("Athens", "LGAV");
        airports.put("Brussels", "EBCI");
        airports.put("London", "EGGW");
        airports.put("Cluj-Napoca", "LRCL");
        airports.put("Berlin",  "EDDB");
        airports.put("Madrid",  "LEMD");
        airports.put("Roma",  "LIRA");
        airports.put("Istanbul",  "LTFM");
        airports.put("Edinburgh",  "EGPH");
        airports.put("Bacău",  "LRBC");
        airports.put("Iaşi",  "LRIA");
        airports.put("Paris",  "LFPG");
    }

    public HashMap<String, String> getAirports() {
        return airports;
    }
}
