package com.airline;
import com.airline.AllData;


import java.util.Random;

import static com.airline.AllData.*;

public class Customer extends AirlineFunc implements login{
    @Override
    public boolean login(String email,String pass)
    {
        for(int i=0;i<customerDetails.size();i++)
        {
            if(customerDetails.get(i).email.equals(email))
            {
                if(customerDetails.get(i).pass.equals(pass)) {
                    return true;
                }
            }
            //System.out.println(customerDetails.get(i));
        }
        return false;
    }

    boolean register(String name,String email,String pass)
    {
        for(int i=0;i<customerDetails.size();i++)
        {
            if(customerDetails.get(i).email.equals(email))
            {
                return false;
            }
            //System.out.println(customerDetails.get(i));
        }

        CustomerData cd = new CustomerData(name,email,pass);
        customerDetails.add(cd);
        return true;
    }

    boolean bookFlight(String email,String fnum,String date)
    {
        Random random = new Random();
        String ticketNum = String.format("%04d", random.nextInt(10000));
        for(int i=0;i<flightDetails.size();i++)
        {
            if(flightDetails.get(i).flightNo.equals(fnum))
            {
                BookedFlight bf = new BookedFlight(ticketNum,email,fnum,flightDetails.get(i).flightName,flightDetails.get(i).flightAirline,flightDetails.get(i).flightSource,flightDetails.get(i).flightDestination,date);
                bookedDetails.add(bf);
                return true;
            }
        }
        return false;
    }

    boolean cancelTicket(String tnum,String email)
    {
        for(int i=0;i<bookedDetails.size();i++)
        {
            if(bookedDetails.get(i).tnum.equals(tnum) && bookedDetails.get(i).passenger.equals(email))
            {
                bookedDetails.remove(i);
                return true;
            }
        }
        return false;
    }


}
