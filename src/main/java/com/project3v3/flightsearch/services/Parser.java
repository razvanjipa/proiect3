package com.project3v3.flightsearch.services;

import com.project3v3.flightsearch.models.Arrival;
import com.project3v3.flightsearch.models.Departure;
import com.project3v3.flightsearch.models.Flight;
import org.apache.tomcat.jni.Local;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import java.io.StringReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<Flight> parserDepartures(String jsonString, String airportName) {

        List<Flight> flights = new ArrayList<Flight>();
        JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
        JsonObject jsonObject = jsonReader.readObject();
        JsonArray jsonDepartures = jsonObject.getJsonArray("departures");
        for (int i = 0; i < jsonDepartures.size(); i++) {
            Flight flight = new Flight();

            //flight assign

            flight.setDeparture(new Departure(parseDate(jsonDepartures.getJsonObject(i).getJsonObject("departure").getString("scheduledTimeUtc", "1990-01-0100:00"))));
            Arrival arrival = new Arrival();
            arrival.setIcao(jsonDepartures.getJsonObject(i).getJsonObject("arrival").getJsonObject("airport").getString("icao", "defaultValue"));
            arrival.setAirportName(jsonDepartures.getJsonObject(i).getJsonObject("arrival").getJsonObject("airport").getString("name", "defaultValue"));
            arrival.setScheduledTimeUtc(parseDate(jsonDepartures.getJsonObject(i).getJsonObject("arrival").getString("scheduledTimeUtc", "1990-01-0100:00")));
            flight.setArrival(arrival);
            flight.setNumber(jsonDepartures.getJsonObject(i).getString("number", "defaultValue"));
            flight.setAirlineName(jsonDepartures.getJsonObject(i).getJsonObject("airline").getString("name", "defaultValue"));



            if (!flight.getArrival().getAirportName().equals("defaultValue") &&
                    !flight.getArrival().getScheduledTimeUtc().equals(LocalDateTime.of(LocalDate.of(1990, 1, 1), LocalTime.of(0, 0))) &&
                    !flight.getDeparture().getScheduledTimeUtc().equals(LocalDateTime.of(LocalDate.of(1990, 1, 1), LocalTime.of(0, 0)))) {
                flight.setDuration(flight.calculateDuration());
                flights.add(flight);
            }
        }

        flights = flights.stream()
                .filter(flight -> flight.getArrival().getAirportName().equals(airportName))
                .collect(Collectors.toList());

        return flights;
    }


    public static boolean convertStringToBoolean(String isCargo) {
        if (isCargo.equals("true"))
            return true;
        return false;
    }

    private static LocalDateTime parseDate(String strDate) {
        if (strDate.endsWith("Z")) {
            strDate = strDate.replace("Z", "");
        }
        if (strDate.contains("T")) {
            strDate = strDate.replace("T", "");
        }
        strDate = strDate.replace(" ", "");


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm");
        return LocalDateTime.parse(strDate, formatter);
    }
}
