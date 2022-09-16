package com.airportassessment.controller.handler;

import com.airportassessment.model.Airport;
import com.airportassessment.model.Data;
import com.airportassessment.model.Runway;

import java.util.Map;

public class AirportHandler {

    /**
     * Handle the associations between the runways and the airports
     * @param data the type with the maps
     */
    public static void handle(Data data){
        for (Map.Entry<String, Runway> entry : data.getRunwayMap().entrySet()){
            Airport airport = getAirport(data.getAirportMap(), entry.getValue().getAirport_ident());
            if(airport != null){
                airport.addRunwayToMap(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Get airport from the airport map using the key
     * @param airportMap the airport map
     * @param key the key
     * @return the airport the key
     */
    private static Airport getAirport(Map<String, Airport> airportMap, String key){
        if(airportMap != null && !key.isEmpty() && airportMap.containsKey(key)){
            return airportMap.get(key);
        }
        return null;
    }
}
