package com.airportassessment.model;

import java.util.Map;

public class Data {
    private Map<String, Country> countryMap;
    private Map<String, Airport> airportMap;
    private Map<String, Runway> runwayMap;

    public Data(Map<String, Country> countryMap, Map<String, Airport> airportMap, Map<String, Runway> runwayMap) {
        this.countryMap = countryMap;
        this.airportMap = airportMap;
        this.runwayMap = runwayMap;
    }

    public Map<String, Country> getCountryMap() {
        return countryMap;
    }

    public void setCountryMap(Map<String, Country> countryMap) {
        this.countryMap = countryMap;
    }

    public Map<String, Airport> getAirportMap() {
        return airportMap;
    }

    public void setAirportMap(Map<String, Airport> airportMap) {
        this.airportMap = airportMap;
    }

    public Map<String, Runway> getRunwayMap() {
        return runwayMap;
    }

    public void setRunwayMap(Map<String, Runway> runwayMap) {
        this.runwayMap = runwayMap;
    }
}
