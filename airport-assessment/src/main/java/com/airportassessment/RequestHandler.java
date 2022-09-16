package com.airportassessment;

import com.airportassessment.controller.handler.AirportHandler;
import com.airportassessment.controller.handler.CountryHandler;
import com.airportassessment.model.Data;
import com.airportassessment.controller.reader.CSVReader;
import com.airportassessment.view.Viewer;

public class RequestHandler {
    private Data data;

    public void executeRequest(String countryName){
        CSVReader csvReader = new CSVReader();
        data = csvReader.readFiles();

        executeHandlers();
        displayRequestedInfo(countryName);
    }

    /**
     * Execute the handlers to populate the objects properly
     */
    private void executeHandlers(){
        AirportHandler.handle(data);
        CountryHandler.handle(data);
    }

    /**
     * Display the requested info
     * @param countryCodeOrName the country
     */
    private void displayRequestedInfo(String countryCodeOrName){
        if(countryCodeOrName.isEmpty()){
            Viewer.displayCountriesWithMoreAirports(data);
        }else{
            Viewer.displayRunwaysByCountry(data, countryCodeOrName);
        }
    }
}
