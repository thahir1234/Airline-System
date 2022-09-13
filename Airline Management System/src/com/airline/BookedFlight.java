package com.airline;

public class BookedFlight {
    String fnum;
    String fname;
    String fairline;
    String fsource;
    String fdes;
    String date;

    String passenger;
    String tnum;
    public BookedFlight(String tnum,String passenger,String fnum, String fname, String fairline, String fsource, String fdes, String date) {
        this.fnum = fnum;
        this.tnum =tnum;
        this.passenger = passenger;
        this.fname = fname;
        this.fairline = fairline;
        this.fsource = fsource;
        this.fdes = fdes;
        this.date = date;
    }
}
