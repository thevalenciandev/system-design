package com.thevalenciandev.design.parkinglot;

import com.thevalenciandev.design.parkinglot.exceptions.NoSpotsAvailableException;
import com.thevalenciandev.design.parkinglot.model.Ticket;
import com.thevalenciandev.design.parkinglot.model.Vehicle;
import com.thevalenciandev.design.parkinglot.services.TicketPaymentService;

public class ParkingLot {

    private final int carSpots;
    private final TicketPaymentService ticketPaymentService;
    private int carSpotsTaken = 0;

    public ParkingLot(int carSpots, TicketPaymentService ticketPaymentService) { // TODO: specify spots for each type of spot
        this.carSpots = carSpots;
        this.ticketPaymentService = ticketPaymentService;
    }

    public Ticket newTicketFor(Vehicle vehicle) throws NoSpotsAvailableException {

        if (!(vehicle instanceof Vehicle.Car)) {
            throw new IllegalArgumentException("Only cars supported for now");
        }

        if (carSpotsTaken == carSpots) {
            throw new NoSpotsAvailableException();
        }

        carSpotsTaken++;
        return new Ticket();
    }

    public int carSpotsAvailable() {
        return carSpots;
    }

    public void pay(Ticket ticket) {
        ticketPaymentService.process(ticket);
    }
}