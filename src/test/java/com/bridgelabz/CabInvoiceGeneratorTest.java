package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 4.0;
        int time = 10;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(50, fare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalOfTotalFare() {
        Ride[] rides = {new Ride(4.0, 5),
                new Ride(5.0, 10),
                new Ride(0.1, 1),
                new Ride(20, 60)
        };
        CabInvoiceGenerator invoiceService = new CabInvoiceGenerator();
        double totalFare = invoiceService.calculateFareForMultipleRides(rides);
        Assertions.assertEquals(260, totalFare, 0);
    }
}