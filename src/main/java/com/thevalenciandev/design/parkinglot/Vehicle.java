package com.thevalenciandev.design.parkinglot;

public class Vehicle {

    static class Car extends Vehicle {

    }

    public static Vehicle car() {
        return new Car();
    }
}
