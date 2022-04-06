package com.parkit.parkingsystem;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;
import com.parkit.parkingsystem.service.FareCalculatorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingSpotTest {

    ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR,true);

    @BeforeAll
    private static void setUp() {
    }

    @BeforeEach
    private void setUpPerTest() {}

    @Test
    public void equalsTestTrue(){
        ParkingSpot testParkingSpot = new ParkingSpot(1,ParkingType.BIKE,true);
        assertTrue(parkingSpot.equals(testParkingSpot));
    }

    @Test
    public void equalsTestFalse(){
        Ticket ticket = new Ticket();
        assertFalse(parkingSpot.equals(ticket));
    }
}
