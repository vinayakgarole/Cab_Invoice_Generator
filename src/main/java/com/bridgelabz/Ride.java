package com.bridgelabz;

public class Ride {

    private double distance;
    private int time;
    private String rideType;

    public Ride(double distance, int time, String rideType) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public String getRideType() {
        return rideType;
    }
}