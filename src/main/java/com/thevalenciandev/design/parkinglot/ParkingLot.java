package com.thevalenciandev.design.parkinglot;

import java.util.Optional;

public class ParkingLot {

    private final int carSpots;
    private int carSpotsTaken = 0;

    public ParkingLot(int carSpots) { // TODO: specify spots for each type of spot
        this.carSpots = carSpots;
    }

    public Optional<Ticket> getTicketFor(Vehicle vehicle) {

        if (!(vehicle instanceof Vehicle.Car)) {
            throw new IllegalArgumentException("Only cars supported for now");
        }

        if (carSpotsTaken == carSpots) {
            return Optional.empty();
        }

        carSpotsTaken++;
        return Optional.of(new Ticket());
    }

}