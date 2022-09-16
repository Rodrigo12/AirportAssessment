package com.airportassessment;

public class Main {
    public static void main(String[] args) {
        RequestHandler requestHandler = new RequestHandler();
        requestHandler.executeRequest( args.length > 0 ? args[0] : "");
    }
}