package com.bridgelabz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabInvoiceGenerator {

    private static final int NORMAL_RIDE_MINIMUM_COST_PER_KILOMETER = 10;
    private static final int NORMAL_RIDE_COST_PER_TIME = 1;
    private static final int NORMAL_RIDE_MIN_FARE = 5;

    private static final int PREMIUM_RIDE_MINIMUM_COST_PER_KILOMETER = 15;
    private static final int PREMIUM_RIDE_COST_PER_TIME = 2;
    private static final int PREMIUM_RIDE_MIN_FARE = 10;

    private static final String NORMAL_RIDE = "NORMAL";
    private static final String PREMIUM_RIDE = "PREMIUM";

    //creating map for multiple rides
    public Map<String, List<Ride>> rideRepository = new HashMap<>();

    //Creating calculateFare method to calculate the fare for the given distance and time
    public double calculateFare(double distance, int time, String rideType) {
        double totalFare = 0.0;
        if (NORMAL_RIDE.equalsIgnoreCase(rideType)) {
            totalFare = distance * NORMAL_RIDE_MINIMUM_COST_PER_KILOMETER + time * NORMAL_RIDE_COST_PER_TIME;
            return Math.max(totalFare, NORMAL_RIDE_MIN_FARE);
        } else if (PREMIUM_RIDE.equalsIgnoreCase(rideType)) {
            totalFare = distance * PREMIUM_RIDE_MINIMUM_COST_PER_KILOMETER + time * PREMIUM_RIDE_COST_PER_TIME;
            return Math.max(totalFare, PREMIUM_RIDE_MIN_FARE);
        }
        return totalFare;
    }

    //Creating calculateFare method with multiple rides
    public InvoiceSummery calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType());
        }
        return new InvoiceSummery(rides.length, totalFare);
    }

    //Multiple rides from rideRepository and return invoice
    public InvoiceSummery calculateFare(String userId) throws CabInvoiceCustomException {
        List<Ride> rides = rideRepository.get(userId);
        if (rides == null) {
            throw new CabInvoiceCustomException("Invalid User", CabInvoiceCustomException.ExceptionType.INVALID_USER);
        }
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType());
        }
        return new InvoiceSummery(rides.size(), totalFare);
    }
}