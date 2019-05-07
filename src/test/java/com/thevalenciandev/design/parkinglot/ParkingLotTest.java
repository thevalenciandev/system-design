package com.thevalenciandev.design.parkinglot;

import com.thevalenciandev.design.parkinglot.exceptions.NoSpotsAvailableException;
import com.thevalenciandev.design.parkinglot.model.LicensePlate;
import com.thevalenciandev.design.parkinglot.model.Ticket;
import com.thevalenciandev.design.parkinglot.model.Vehicle;
import com.thevalenciandev.design.parkinglot.services.TicketPaymentService;
import org.junit.Test;

import java.util.Optional;

import static com.thevalenciandev.design.parkinglot.com.thevalenciandev.support.Thrower.exceptionFrom;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ParkingLotTest {

    private final TicketPaymentService ticketPaymentService = mock(TicketPaymentService.class);

    @Test
    public void providesNumberOfCarSpotsAvailable() {

        ParkingLot parkingLot = new ParkingLot(1, ticketPaymentService);

        assertThat(parkingLot.carSpotsAvailable(), is(1));
    }

    @Test
    public void throwsExceptionIfNoSpacesAvailable() throws NoSpotsAvailableException {

        ParkingLot parkingLot = new ParkingLot(1, ticketPaymentService);

        assertThat(parkingLot.newTicketFor(Vehicle.newCar(LicensePlate.of("ABC"))), not(equalTo(Optional.empty())));
        assertThat(exceptionFrom(() -> parkingLot.newTicketFor(Vehicle.newCar(LicensePlate.of("DEF")))),
                instanceOf(NoSpotsAvailableException.class));
    }

    @Test
    public void redirectsTicketPaymentToTicketPaymentService() throws NoSpotsAvailableException {

        ParkingLot parkingLot = new ParkingLot(1, ticketPaymentService);

        Ticket ticket = parkingLot.newTicketFor(Vehicle.newCar(LicensePlate.of("ABC")));
        parkingLot.pay(ticket);

        verify(ticketPaymentService).process(ticket);
    }

}