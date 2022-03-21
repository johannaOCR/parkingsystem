package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;

import java.util.Date;

public class FareCalculatorService {

    public void calculateFare(Ticket ticket){
        if( (ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime())) ){
            throw new IllegalArgumentException("Out time provided is incorrect:"+ticket.getOutTime().toString());
        }

        Date inHour = ticket.getInTime();
        Date outHour = ticket.getOutTime();
        double duration = ((double) ((outHour.getTime() - inHour.getTime())/60000)/60);

        if (duration>0.5){
        switch (ticket.getParkingSpot().getParkingType()){
            case CAR: {
                if(ticket.isRecuringUser()){
                    System.out.println("Vous bénéficiez d'une reduction de 30%");
                    ticket.setPrice(Math.round((duration * Fare.CAR_RATE_PER_HOUR * Fare.RECURING_USER_REDUCTION)* 100.0) / 100.0);
                } else {
                    ticket.setPrice(Math.round((duration * Fare.CAR_RATE_PER_HOUR)* 100.0) / 100.0);
                }
                break;
            }
            case BIKE: {
                if(ticket.isRecuringUser()){
                    ticket.setPrice(Math.round((duration * Fare.BIKE_RATE_PER_HOUR * Fare.RECURING_USER_REDUCTION)* 100.0) / 100.0);
                    System.out.println("Vous bénéficiez d'une reduction de 30%");
                } else {
                    ticket.setPrice(Math.round((duration * Fare.BIKE_RATE_PER_HOUR)* 100.0) / 100.0);
                }
                break;
            }
            default: throw new IllegalArgumentException("Unkown Parking Type");
        }
        } else {
            ticket.setPrice(0);
        }
    }
}
