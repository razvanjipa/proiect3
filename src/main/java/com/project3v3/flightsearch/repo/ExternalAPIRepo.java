package com.project3v3.flightsearch.repo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalAPIRepo {
    public HttpResponse<String> method(String icao,String departureDate) throws UnirestException;
}
