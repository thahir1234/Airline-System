package com.airline;
import com.airline.AllData.*;

import static com.airline.AllData.bookedDetails;
import static com.airline.AllData.flightDetails;

public abstract class AirlineFunc {

    void viewFlights()
    {
        if(flightDetails.size()>0) {
            System.out.println("Flight No.\t\tFlight Name\t\tFlight Airline\t\tFlight Source\t\tFlight Destination");
            //System.out.format("%32s%10s20s%20s%20s","Flight No.","Flight Name","Flight Airline","Flight Source","Flight Destination");
            for (int i = 0; i < flightDetails.size(); i++) {
                System.out.println(flightDetails.get(i).flightNo + "\t\t\t    " + flightDetails.get(i).flightName + "\t\t\t   " + flightDetails.get(i).flightAirline + "\t\t\t   " + flightDetails.get(i).flightSource + "\t\t\t   " + flightDetails.get(i).flightDestination + "\t\t\t");
            }
        }
        else {
            System.out.println("No Flights Avaliable");
        }
    }

    void viewBookedFlights(String email)
    {
        int f=0;
        System.out.println("Ticket Number\t\tPassenger\t\tFlight Number\t\tFlight Name\t\t\t   Flight Airline\t\tFlight Source\t\tFlight Destination\t\tFlight Date");
        for(int i=0;i<bookedDetails.size();i++)
        {
            if(bookedDetails.get(i).passenger.equals(email))
            {
                f=1;
                System.out.println(bookedDetails.get(i).tnum+"\t\t\t\t"+bookedDetails.get(i).passenger+"\t\t\t\t"+bookedDetails.get(i).fnum+"\t\t\t\t"+bookedDetails.get(i).fname+"\t\t\t\t"+bookedDetails.get(i).fairline+"\t\t\t\t"+bookedDetails.get(i).fsource+"\t\t\t\t"+bookedDetails.get(i).fdes+"\t\t\t\t"+bookedDetails.get(i).date);
            }
        }
        if(f==0)
        {
            System.out.println("You have not booked any tickets yet..");
        }
    }

    void viewBookedFlights() {
        if(bookedDetails.size()>0) {
            System.out.println("Ticket Number\t\tPassenger\t\tFlight Number\t\tFlight Name\t\t\t   Flight Airline\t\tFlight Source\t\tFlight Destination\t\tFlight Date");
            for (int i = 0; i < bookedDetails.size(); i++) {
                System.out.println(bookedDetails.get(i).tnum + "\t\t\t\t" + bookedDetails.get(i).passenger + "\t\t\t\t" + bookedDetails.get(i).fnum + "\t\t\t\t" + bookedDetails.get(i).fname + "\t\t\t\t" + bookedDetails.get(i).fairline + "\t\t\t\t" + bookedDetails.get(i).fsource + "\t\t\t\t" + bookedDetails.get(i).fdes + "\t\t\t\t" + bookedDetails.get(i).date);
            }
        }
        else {
            System.out.println("No Booked Tickets currently Available");
        }
    }
    abstract boolean login(String email,String pass);
    //abstract void viewBookedFlights(String email);

}
