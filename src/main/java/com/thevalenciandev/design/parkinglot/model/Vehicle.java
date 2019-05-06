package com.thevalenciandev.design.parkinglot.model;

public class Vehicle {

    public final LicensePlate plate;

    private Vehicle(LicensePlate plate) {
        this.plate = plate;
    }

    public static class Car extends Vehicle {

        public Car(LicensePlate plate) {
            super(plate);
        }
    }

    public static Vehicle car(LicensePlate plate) {
        return new Car(plate);
    }
}
