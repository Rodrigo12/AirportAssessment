package com.airportassessment.controller.reader;

import com.airportassessment.controller.ObjectGenerator;
import com.airportassessment.model.Airport;
import com.airportassessment.model.Country;
import com.airportassessment.model.Data;
import com.airportassessment.model.Runway;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {
    private final String AIRPORTS_CSV = "airports.csv";
    private final String COUNTRIES_CSV = "countries.csv";
    private final String RUNWAYS_CSV = "runways.csv";

    /**
     * Read the resource files
     */
    public Data readFiles(){
        Map<String, Country> countries = generateObjectsFromCSV(COUNTRIES_CSV, Country.class);
        Map<String, Airport> airports = generateObjectsFromCSV(AIRPORTS_CSV, Airport.class);
        Map<String, Runway> runways = generateObjectsFromCSV(RUNWAYS_CSV, Runway.class);

        return new Data(countries, airports, runways);
    }

    /**
     * Generate objects (Airports, Countries or Runways) from CSV files
     * @param fileName the csv file name
     * @param type the object type (Airport, Country or Runway)
     * @return list of objects generated from the csv file (Airports, Countries or Runways)
     * @param <T> the type (Airport, Country or Runway)
     */
    private <T> Map<String, T> generateObjectsFromCSV(String fileName, Class<T> type)
    {
        Map<String, T> objects = new HashMap<>();
        InputStream is = getFileFromResourceAsStream(fileName);
        ObjectGenerator.createObjectsFromStream(is, objects, type);
        return objects;
    }

    /**
     * Get a file from the resources folder
     * @param fileName name of the file in resources
     * @return input stream from the file content
     */
    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("Error Getting File From Resources: File not found " + fileName);
        } else {
            return inputStream;
        }

    }
}
