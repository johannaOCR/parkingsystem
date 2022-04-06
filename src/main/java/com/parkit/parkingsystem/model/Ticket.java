package com.parkit.parkingsystem.model;

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

    public void setParkingSpot(ParkingSpot parkingSpot) {
        ParkingSpot parkingSpot1 = new ParkingSpot(this.parkingSpot.getId(), this.parkingSpot.getParkingType(), this.parkingSpot.isAvailable());
        this.parkingSpot = parkingSpot1;
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
        Date ladate = new Date();
        ladate.setTime(outTime.getTime());
        return ladate;
    }

    public void setOutTime(Date outTime) {
        Date outTime1 = new Date(outTime.getTime());
        this.outTime = outTime1;
    }
}
