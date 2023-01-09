package com.project3v3.flightsearch.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Arrival {

    private String icao;
    private String airportName;

    private LocalDateTime scheduledTimeUtc;

    public Arrival(){

    }

    public Arrival(String icao, String airportName, LocalDateTime scheduledTimeUtc) {
        this.icao = icao;
        this.airportName = airportName;
        this.scheduledTimeUtc = scheduledTimeUtc;
    }

    public LocalDateTime getScheduledTimeUtc() {
        return scheduledTimeUtc;
    }

    public void setScheduledTimeUtc(LocalDateTime scheduledTimeUtc) {
        this.scheduledTimeUtc = scheduledTimeUtc;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

}
