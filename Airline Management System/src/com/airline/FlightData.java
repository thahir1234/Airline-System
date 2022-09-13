package com.airline;

import java.util.Random;

public class FlightData {
    String flightNo;
    String flightAirline;
    String flightName;
    String flightSource;
    String flightDestination;

    public FlightData( String flightAirline, String flightName, String flightSource, String flightDestination) {
        Random random = new Random();
        this.flightNo = String.format("%04d", random.nextInt(10000));
        this.flightAirline = flightAirline;
        this.flightName = flightName;
        this.flightSource = flightSource;
        this.flightDestination = flightDestination;
    }
}
