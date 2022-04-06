package com.parkit.parkingsystem.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import javax.annotation.Nullable;
import java.util.Calendar;
import java.util.Date;

public class Ticket {
    private int id;
    private ParkingSpot parkingSpot;
    private String vehicleRegNumber;
    private double price;
    private Date inTime;
    private Date outTime;
    private boolean isRecuringUser;

    public boolean isRecuringUser() {
        return isRecuringUser;
    }

    public void setRecuringUser(boolean recuringUser) {
        isRecuringUser = recuringUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSpot getParkingSpot() {
        return new ParkingSpot(this.parkingSpot.getId(), this.parkingSpot.getParkingType(), this.parkingSpot.isAvailable());
    }

    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    public void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getInTime() {
        Date inTime1 = new Date(this.inTime.getTime());
        return inTime1;
    }

    public void setInTime(Date inTime) {
        Date inTime1 = new Date(inTime.getTime());
        this.inTime = inTime1;
    }

    public Date getOutTime() {
        if(outTime != null){
            Date ladate = new Date();
            ladate.setTime(outTime.getTime());
            return ladate;
        } else {
            return null;
        }

    }

    public void setOutTime(Date outTime) {
        if(outTime!=null){
            Date outTime1 = new Date(outTime.getTime());
            this.outTime = outTime1;
        } else {
            this.outTime = null;
        }

    }
}
