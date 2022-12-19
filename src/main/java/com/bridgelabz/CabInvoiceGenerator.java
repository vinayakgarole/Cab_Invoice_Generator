package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

public class CabInvoiceGenerator {

    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final int MIN_FARE = 5;
    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
        if (totalFare < MIN_FARE) {
            return MIN_FARE;
        }
        return totalFare;
    }
    public double calculateFareForMultipleRides(Ride[] rides) {
        // variable
        double totalFare = 0.0;
        /**
         * using for each loop
         */
        for (Ride ride : rides) {
            totalFare = calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }

    /**
     * create a method name as invoiceSummaryCalculation
     *
     * @param rides total no of rides
     * @return invoice summaray calculation return total ride
     */
    public InvoiceSummery invoiceSummaryCalculation(Ride[] rides) {
        //variable
        double totalFare = 0.0;
        /**
         * using for each loop for total fare
         */
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        /**
         * return total invoice summary
         */
        return new InvoiceSummery(rides.length, totalFare);
    }

    /**
     * create a method name as getInvoice
     *
     * @param userId given user id
     * @return tatal rides array
     */
    public InvoiceSummery getInvoice(int userId) {
        /**
         * crete a map object
         */
        Map<Integer, Ride[]> map = new HashMap<>();
        /**
         * 1st ride
         */
        Ride[] rides1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        /**
         * 2nd ride
         */
        Ride[] rides2 = {new Ride(5.0, 10),
                new Ride(1, 1)
        };

        /**
         * 3rd ride
         */
        Ride[] rides3 = {new Ride(8.0, 15),
                new Ride(1, 10)
        };
        /**
         * calling put method from map object
         */
        map.put(1, rides1);
        map.put(2, rides2);
        map.put(3, rides3);

        for (Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
            if (userId == entry.getKey()) {
                System.out.println(entry.getKey());
                Ride[] ridesArray = entry.getValue();
                return invoiceSummaryCalculation(ridesArray);
            }
        }
        return null;
    }


    /**
     * create a main method ,all program execute in main method
     *
     * @param args no arguments
     */
    public static void main(String[] args) {
        /**
         * create object for CabInvoiceGenerator class, object name is cabInvoiceGenerator
         */
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        /**
         * calling CalculateFare method from cabInvoiceGenerator object
         * and print o/p
         */
        System.out.println(cabInvoiceGenerator.calculateFare(5, 20) + " Rs");

        /**
         * rides array = distance,time
         */
        Ride[] ridesArray = {
                new Ride(0.1, 1),
                new Ride(1, 1),
                new Ride(1, 10)
        };
        /**
         * calling getInvoice method from cabInvoiceGenerator object
         */
        cabInvoiceGenerator.getInvoice(1);
    }
}