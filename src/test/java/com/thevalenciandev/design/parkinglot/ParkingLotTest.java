package com.thevalenciandev.design.parkinglot;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    @Test
    public void allowsEntryOnlyIfSpacesAvailable() {

        ParkingLot parkingLot = new ParkingLot(1);

        assertThat(parkingLot.getTicketFor(Vehicle.car()), not(equalTo(Optional.empty())));
        assertThat(parkingLot.getTicketFor(Vehicle.car()), equalTo(Optional.empty()));
    }

}