package com.thevalenciandev.design.parkinglot.model;

public class LicensePlate {

    public final String number;

    private LicensePlate(String number) {
        this.number = number;
    }

    public static LicensePlate of(String number) {
        return new LicensePlate(number);
    }
}
