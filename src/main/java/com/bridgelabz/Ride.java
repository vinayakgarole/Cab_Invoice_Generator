package com.bridgelabz;

public class Ride {

    private final double distance;
    private final int time;
    public Ride(double distance, int time) {

        /**
         *  The "this" keyword is used to refer to the current object.
         */
        this.distance = distance;
        this.time = time;
    }
    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;

    }
}