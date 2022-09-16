package com.airportassessment.controller.handler;

import com.airportassessment.model.Airport;
import com.airportassessment.model.Country;
import com.airportassessment.model.Data;

import java.util.*;

public class CountryHandler {
    /**
     * Handle the associations between the airports and the countries
     * @param data the type with the maps
     */
    public static void handle(Data data){
        for (Map.Entry<String, Airport> entry : data.getAirportMap().entrySet()){
            Country country = getCountry(data.getCountryMap(), entry.getValue().getIso_country());
            if(country != null){
                country.addAirportToMap(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Get airport from the country map using the key
     * @param countryMap the country map
     * @param key the key
     * @return the country the key
     */
    private static Country getCountry(Map<String, Country> countryMap, String key){
        if(countryMap != null && !key.isEmpty() && countryMap.containsKey(key)){
            return countryMap.get(key);
        }
        return null;
    }

    /**
     * Get country but country code or name
     * @param countryMap map with countries
     * @param countryCodeOrName country code or name
     * @return the country
     */
    public static Country getCountryByCodeOrName(Map<String, Country> countryMap, String countryCodeOrName){
        if(countryMap.containsKey("\"" + countryCodeOrName + "\"")){
            return countryMap.get("\"" + countryCodeOrName + "\"");
        }

        for (Map.Entry<String, Country> entry : countryMap.entrySet()){
            if(entry.getValue().getName().toLowerCase().contains(countryCodeOrName.toLowerCase())){
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * Get 10 countries with the highest number of airports
     * @param countryMap the country map
     * @return list with 10 countries with highest number of airports
     */
    public static List<Country> getCountriesMoreAirports(Map<String, Country> countryMap){
        List<Map.Entry<String, Integer>> countryAirportCount = new ArrayList<>();
        // Count the airport number for each country
        for (Map.Entry<String, Country> entry : countryMap.entrySet()){
            countryAirportCount.add(new AbstractMap.SimpleEntry<>(entry.getValue().getCode(), entry.getValue().getAirportMap().size()));
        }

        // Sort the list of airports number
        countryAirportCount.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        List<Country> countriesMoreAirports = new ArrayList<>();
        // Get the list of 10 countries with the highest number of airports
        for (Map.Entry<String, Integer> entry : countryAirportCount.subList(0, 10)) {
            countriesMoreAirports.add(countryMap.get(entry.getKey()));
        }

        return countriesMoreAirports;
    }

}
