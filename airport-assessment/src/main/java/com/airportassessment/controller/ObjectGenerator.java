package com.airportassessment.controller;

import com.airportassessment.model.Airport;
import com.airportassessment.model.Country;
import com.airportassessment.model.Runway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ObjectGenerator {
    /**
     * Generate objects from the stream
     * @param is input stream
     * @param objects list of objects
     * @param type objects types
     * @param <T> type
     */
    public static <T> void createObjectsFromStream(InputStream is, Map<String, T> objects, Class<T> type) {
        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            reader.readLine();
            String line; //jump first line
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",", -1);
                createObject(attributes, type, objects);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create an Airport, Country or Runway
     * @param attributes attrs fetched from the csv file
     * @param type Airport, Country or Runway
     * @return the object generated
     * @param <T> Airport, Country or Runway
     */
    private static <T> void createObject(String[] attributes, Class<T> type, Map<String, T>  objects){
        String typeName = type.getName();
        if(typeName.equals(Airport.class.getName())){ // Airport
            Airport airport = new Airport(attributes);
            objects.put(airport.getIdent(), type.cast(airport));
        }else if(typeName.equals(Country.class.getName())){ // Country
            Country country = new Country(attributes);
            objects.put(country.getCode(), type.cast(country));
        }else if(typeName.equals(Runway.class.getName())){ // Runway
            Runway runway = new Runway(attributes);
            objects.put(runway.getId() + "", type.cast(runway));
        }else{
            // Log Error
            System.out.println("Error creating object: Unknown type " + typeName);
        }
    }
}
