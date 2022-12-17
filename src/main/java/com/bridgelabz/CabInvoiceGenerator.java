package com.bridgelabz;

public class CabInvoiceGenerator {

    private static final int MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;


    public static double calculateFare(double distance, int time) {
        return distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
    }

    public double calculateFareForMultipleRides(Ride[] rides) {

        double totalFare = 0.0;

        for (Ride ride : rides) {
            totalFare = calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }

    public static void main(String[] args) {

        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        System.out.println(cabInvoiceGenerator.calculateFare(5, 20) + " Rs");
    }
}
