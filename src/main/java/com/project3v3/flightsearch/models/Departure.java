package com.project3v3.flightsearch.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Departure {

    private String icao;
    private String airportName;
    private String municipalityName;
    private LocalDateTime scheduledTimeUtc;

    public Departure(){

    }

    public Departure(LocalDateTime scheduledTimeUtc) {
        this.scheduledTimeUtc = scheduledTimeUtc;
    }

    public Departure(String icao, String airportName, String municipalityName, LocalDateTime scheduledTimeUtc) {
        this.icao = icao;
        this.airportName = airportName;
        this.municipalityName = municipalityName;
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

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public LocalDateTime getScheduledTimeUtc() {
        return scheduledTimeUtc;
    }

    public void setScheduledTimeUtc(LocalDateTime scheduledTimeUtc) {
        this.scheduledTimeUtc = scheduledTimeUtc;
    }
}
