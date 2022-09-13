package com.airline;

import java.util.Scanner;

public class Main {
    static final Scanner sc = new Scanner(System.in);
    static final Customer c = new Customer();
    static AirlineFunc a= new Customer();
    public static void main(String[] args) {
        String cusName,cusEmail,cusPass,adminUname,adminPass;
        int p=0;
        char con='y';

        do {
            p=0;
            System.out.println("\n***** Welcome to Online Flight Booking *****");
            System.out.println("** Main Menu **");
            System.out.println("1.Register as a customer");
            System.out.println("2.Login as a customer");
            System.out.println("3.Login as a admin");
            System.out.println("4.Exit");
            System.out.println("Enter your choice:");
            int ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.println("\nEnter your name:");
                    cusName = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter your Email id:");
                    cusEmail = sc.next();
                    System.out.println("Enter your password:");
                    cusPass = sc.next();
                    Customer c1 = new Customer();
                    if(c1.register(cusName,cusEmail,cusPass))
                    {
                        System.out.println("Registered Successfully");
                    }
                    else {
                        System.out.println("Registered Failed!!");
                    }
                    p=1;
                    break;
                case 2:
                    System.out.println("\nEnter your email id:");
                    cusEmail = sc.next();
                    //sc.nextLine();
                    System.out.println("Enter your password:");
                    cusPass = sc.next();
                    sc.nextLine();
                    Customer c2 = new Customer();
                    if(c2.login(cusEmail,cusPass))
                    {
                        System.out.println("Login Successfull");
                        customerMenu(cusEmail,cusEmail);
                    }
                    else {
                        p=1;
                        System.out.println("Login Failed!!");
                    }
                    break;
                case 3:
                    System.out.println("\nEnter admin username:");
                    adminUname=sc.next();
                    System.out.println("Enter admin password:");
                    adminPass=sc.next();
                    Admin a = new Admin();
                    if(a.login(adminUname,adminPass))
                    {
                        System.out.println("Admin Login Successfull");
                        adminMenu();
                    }
                    else {
                        System.out.println("Admin Login Failed");
                    }
                    break;
                case 4:
                    System.exit(0);
            }

        }while(true);

    }

    static void customerMenu(String cname,String email) {
        do {
            int cmChoice;
            System.out.println("\n** Customer Menu **");
            System.out.println("1.View Flights");
            System.out.println("2.View Booked Flights");
            System.out.println("3.Book Flight");
            System.out.println("4.Cancel Booked Flight");
            System.out.println("5.Logout");
            System.out.print("\nEnter your choice:");
            cmChoice = sc.nextInt();
            switch (cmChoice) {
                case 1:
                    AirlineFunc af = new Customer();
                    af.viewFlights();
                    break;
                case 2:
                    a.viewBookedFlights(email);
                    //c.viewBookedFlights(email);
                    break;
                case 3:
                    System.out.println("Enter the flight No.(4 digit) which you want to book:");
                    String fnum = sc.next();
                    System.out.println("Enter the date(dd/mm/yyy):");
                    String date = sc.next();
                    if (c.bookFlight(email, fnum, date)) {
                        System.out.println("Flight Booked Successfully - " + fnum + "...You can view your ticket in booked flights:->");
                    } else {
                        System.out.println("Booking Failed!! Flight Not Avaliable");
                    }
                    break;
                case 4:
                    System.out.println("Enter a Ticket No.(Already Booked) to be cancelled:");
                    String tnum = sc.next();
                    if (c.cancelTicket(tnum,email)) {
                        System.out.println("Your Ticket - " + tnum + " has been Cancelled");
                    } else {
                        System.out.println("Cancellation Failed!!");
                    }
                    break;
                case 5:
                    System.out.println("Logging Out...Bye\n");
                    return;
                default:
                    System.out.println("Enter a Valid Choice!!");
            }
        }while(true);
    }

    static void adminMenu()
    {
        String fname,alname,src,des;
        AirlineFunc af = new Admin();
        Admin ad = new Admin();
        do {
            int adchoice;
            System.out.println("\n** Admin Menu **");
            System.out.println("1.View Flight Details");
            System.out.println("2.Add Flight");
            System.out.println("3.Delete Flight");
            System.out.println("4.View all Tickets");
            System.out.println("5.Logout");
            System.out.println("Enter your choice:");
            adchoice = sc.nextInt();
            switch(adchoice)
            {
                case 1:
                    af.viewFlights();
                    break;
                case 2:
                    System.out.println("Enter Flight Name:");
                    fname = sc.next();
                    //sc.nextLine();
                    System.out.println("Enter Airline Name:");
                    alname = sc.next();
                    //sc.nextLine();
                    System.out.println("Enter the source location:");
                    src = sc.next();
                    System.out.println("Enter the destination location:");
                    des = sc.next();
                    ad.addFlight(fname,alname,src,des);
                    System.out.println("Flight Added Successfully..\n");
                    break;
                case 3:
                    System.out.println("Enter the Flight No.(4 digit) to be deleted:");
                    String fnum = sc.next();
                    if(ad.deleteFlight(fnum))
                    {
                        System.out.println("Flight Details Deleted Successfully..");
                    }
                    else {
                        System.out.println("Deletion failed..Flight detail may not exist");
                    }
                    break;
                case 4:
                    a.viewBookedFlights();
                    break;
                case 5:
                    System.out.println("Logging Out...\n");
                    return;
                default:
                    System.out.println("Enter a valid choice...\n");
            }
        }while(true);
    }
}
