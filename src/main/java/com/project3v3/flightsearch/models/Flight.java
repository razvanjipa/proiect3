package com.project3v3.flightsearch.models;

public class Flight {
    private Departure departure;
    private Arrival arrival;
    private String number;
    private String airlineName;
    private String duration;

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String calculateDuration(){
        int arrivalHour=this.arrival.getScheduledTimeUtc().getHour();
        int arrivalMinutes=this.arrival.getScheduledTimeUtc().getMinute();
        int departureHour=this.departure.getScheduledTimeUtc().getHour();
        int departureMinutes=this.departure.getScheduledTimeUtc().getMinute();
        if(arrivalHour*60+arrivalMinutes < departureHour*60+departureMinutes){
            return String.valueOf((24*60-departureHour*60+departureMinutes + arrivalHour*60+arrivalMinutes)/60)+"h"+
                    ((24*60-departureHour*60+departureMinutes + arrivalHour*60+arrivalMinutes)%60)+"m";
        }
        return String.valueOf((arrivalHour*60+arrivalMinutes-departureHour*60-departureMinutes)/60)+"h"+
                ((arrivalHour*60+arrivalMinutes-departureHour*60-departureMinutes)%60)+"m";
    }
}
