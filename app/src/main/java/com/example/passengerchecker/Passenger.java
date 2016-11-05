package com.example.passengerchecker;

/**
 * Created by jeevansai on 04/11/2016.
 */

public class Passenger {
    String pname;
    int age;
    String sex;
    int seatno;
    String coachno;
    String source;
    String destination;
    String doj;
    String arrival;
    String departure;
    String trainnumber;
    String trainname;
    String status;
    String mobileno;
    String pnrno;
    Passenger(String pname,int age,String sex,int seatno,String coacho,String source,String destination,String doj,String arrival,String departure,String trainnumber,String trainname,String status,String mobileno,String pnrno)
    {
        this.pname=pname;
        this.age=age;
        this.sex=sex;
        this.seatno=seatno;
        this.coachno=coacho;
        this.source=source;
        this.destination=destination;
        this.doj=doj;
        this.arrival=arrival;
        this.departure=departure;
        this.trainnumber=trainnumber;
        this.trainname=trainname;
        this.status=status;
        this.mobileno=mobileno;
        this.pnrno=pnrno;
    }
}
