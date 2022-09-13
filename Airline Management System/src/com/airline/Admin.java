package com.airline;

import static com.airline.AllData.*;
public class Admin extends AirlineFunc implements login{

    @Override
    public boolean login(String email, String pass) {
        if(email.equals("admin"))
        {
            if(pass.equals("admin123"))
            {
                return true;
            }
        }
        return false;
    }



    void addFlight(String fname,String alname,String source,String desti)
    {
        FlightData fd = new FlightData(alname,fname,source,desti);
        flightDetails.add(fd);
    }

    boolean deleteFlight(String fnum){
        for(int i=0;i<flightDetails.size();i++)
        {
            if(flightDetails.get(i).flightNo.equals(fnum))
            {
                flightDetails.remove(i);
                return true;
            }
        }
        return false;
    }
}
