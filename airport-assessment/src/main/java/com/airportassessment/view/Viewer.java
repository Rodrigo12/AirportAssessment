package com.airportassessment.view;

import com.airportassessment.controller.handler.CountryHandler;
import com.airportassessment.model.Airport;
import com.airportassessment.model.Country;
import com.airportassessment.model.Data;
import com.airportassessment.model.Runway;

import java.util.List;
import java.util.Map;

public class Viewer {

    public static void displayAllAirportsWithRunways(Country country){
        for (Map.Entry<String, Airport> entry : country.getAirportMap().entrySet()){
            System.out.println("Airport: " + entry.getValue().getName() + " : " + entry.getValue().getIdent());
            for (Map.Entry<String, Runway> entryRunway : entry.getValue().getRunwayMap().entrySet()){
                System.out.println("Runway: " + entryRunway.getValue().getId() + " --> " + entryRunway.getValue().getAirport_ident());
            }
            System.out.println("-------------------------------");
        }
    }

    public static void displayAllCountriesWithAirports(Data data){
        for (Map.Entry<String, Country> entry : data.getCountryMap().entrySet()){
            System.out.println("Country: " + entry.getValue().getName() + " : " + entry.getValue().getCode());
            for (Map.Entry<String, Airport> entryAirport : entry.getValue().getAirportMap().entrySet()){
                System.out.println("Airport: " + entryAirport.getValue().getId() + " --> " + entryAirport.getValue().getIso_country());
            }
            System.out.println("-------------------------------");
        }
    }

    public static void displayAllInformation(Data data){
        for (Map.Entry<String, Country> entry : data.getCountryMap().entrySet()){
            System.out.println("Country: " + entry.getValue().getName() + " : " + entry.getValue().getCode());
            for (Map.Entry<String, Airport> entryAirport : entry.getValue().getAirportMap().entrySet()){
                System.out.println("Airport: " + entryAirport.getValue().getId() + " --> " + entryAirport.getValue().getIso_country());
                for (Map.Entry<String, Runway> entryRunway : entryAirport.getValue().getRunwayMap().entrySet()){
                    System.out.println("Runway: " + entryRunway.getValue().getId() + " --> " + entryRunway.getValue().getAirport_ident());
                }
            }
            System.out.println("-------------------------------");
        }
    }

    public static void displayRunwaysByCountry(Data data, String countryCodeOrName){
        Country country = CountryHandler.getCountryByCodeOrName(data.getCountryMap(), countryCodeOrName);
        if(country != null){
            System.out.println("country: " + country.getName());
            displayAllAirportsWithRunways(country);
        }else{
            System.out.println("Unable to find country with name or code: " + countryCodeOrName);
        }
    }

    public static void displayCountriesWithMoreAirports(Data data){
        List<Country> countries = CountryHandler.getCountriesMoreAirports(data.getCountryMap());
        if(!countries.isEmpty()){
            for (Country country: countries) {
                System.out.println("Country " + country.getName() + " has " + country.getAirportMap().size() + " airports");
            }
        }else{
            System.out.println("Unable to find the countries with more airports");
        }
    }
}
