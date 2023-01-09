package com.project3v3.flightsearch.controllers;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.project3v3.flightsearch.models.Flight;
import com.project3v3.flightsearch.repo.ExternalAPIRepo;
import com.project3v3.flightsearch.services.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FlightController {
    @Autowired
    public ExternalAPIRepo externalAPI;

    @RequestMapping(value = "/flights", method = RequestMethod.POST)
    public List<Flight> getFlights(@RequestBody FlightRequest  flightRequest) throws UnirestException {

//        arrivalAirportName="Roma";
//        return externalAPI.method().getBody();
        return Parser.parserDepartures( externalAPI.method(flightRequest.getDepartureAirportName(),flightRequest.getDepartureDate()).getBody(), flightRequest.getArrivalAirportName());

    }

}
