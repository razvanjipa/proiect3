package com.project3v3.flightsearch.externalAPI;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.project3v3.flightsearch.models.IcaoCodes;
import com.project3v3.flightsearch.repo.ExternalAPIRepo;
import org.springframework.stereotype.Service;

@Service
public class ExternalAPI implements ExternalAPIRepo {

    public HttpResponse<String> method(String airportName,String departureDate) throws UnirestException{
        IcaoCodes icaocodes = new IcaoCodes();
        icaocodes.initialize();
        String icao=icaocodes.getAirports().get(airportName);

        HttpResponse<String> response = Unirest.get("https://aerodatabox.p.rapidapi.com/flights/airports/icao/"+icao+"/"+departureDate+"T05:00/"+departureDate+"T17:00?withLeg=true&withCancelled=true&withCodeshared=true&withCargo=true&withPrivate=true&withLocation=false")
                .header("x-rapidapi-host", "aerodatabox.p.rapidapi.com")
//                .header("x-rapidapi-key", "baade65ddfmshbf07c6a8a594f77p126ceajsn55359f56e9f1")
                .header("x-rapidapi-key", "a167dbf1d7msh3aa2a8996a9fb11p1a19d3jsnd9d16346b527")
                .asString();
        return response;
    }

}
