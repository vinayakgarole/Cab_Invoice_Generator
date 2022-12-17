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
}