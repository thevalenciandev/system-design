package com.thevalenciandev.design.parkinglot;

import com.thevalenciandev.design.parkinglot.exceptions.NoSpotsAvailableException;
import com.thevalenciandev.design.parkinglot.model.LicensePlate;
import com.thevalenciandev.design.parkinglot.model.Vehicle;
import org.junit.Test;

import java.util.Optional;

import static com.thevalenciandev.design.parkinglot.com.thevalenciandev.support.Thrower.exceptionFrom;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    @Test
    public void providesNumberOfCarSpotsAvailable() {

        ParkingLot parkingLot = new ParkingLot(1);

        assertThat(parkingLot.carSpotsAvailable(), is(1));
    }

    @Test
    public void throwsExceptionIfNoSpacesAvailable() throws NoSpotsAvailableException {

        ParkingLot parkingLot = new ParkingLot(1);

        assertThat(parkingLot.newTicketFor(Vehicle.newCar(LicensePlate.of("ABC"))), not(equalTo(Optional.empty())));
        assertThat(exceptionFrom(() -> parkingLot.newTicketFor(Vehicle.newCar(LicensePlate.of("DEF")))),
                instanceOf(NoSpotsAvailableException.class));
    }

}