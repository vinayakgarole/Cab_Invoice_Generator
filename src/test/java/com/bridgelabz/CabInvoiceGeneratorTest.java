package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();//creating object of CabInvoiceGenerator class

    @Test
    public void givenDistanceAndTime_ShouldReturn_TotalFare() {
        double distance = 5.5;
        int time = 10;
        double fare = cabInvoiceGenerator.calculateFare(distance, time, "NoRMAL");//Using object reference calling calculateFare method with parameters
        Assertions.assertEquals(65, fare);//Verifies that the expected and actual values are equal
    }

    //calculate minimum fare using distance and time
    @Test
    public void givenMinDistanceAndTime_ShouldReturn_MinFare() {
        double distance = 1.5;
        int time = 5;
        double fare = cabInvoiceGenerator.calculateFare(distance, time, "NORMAL");//Using object reference calling calculateFare method with parameters
        Assertions.assertEquals(20, fare);//Verifies that the expected and actual values are equal
    }

    @Test
    public void givenMultipleRides_ShouldReturn_TotalInvoice() {
        Ride[] rides = {
                new Ride(4.5, 10, "NORMAL"),
                new Ride(5.5, 10, "PREMIUM")
        };
        InvoiceSummery invoice = cabInvoiceGenerator.calculateFare(rides);//using object calling calculateFare method
        InvoiceSummery expectedInvoice = new InvoiceSummery(2, 120.0);//invoice store in expectedInvoice
        Assertions.assertEquals(invoice, expectedInvoice);
    }

    @Test
    public void givenUserId_WhenValid_ShouldReturn_Invoice() {
        Ride[] rides = {
                new Ride(2.0, 5, "PREMIUM"),
                new Ride(3.1, 5, "PREMIUM")
        };
        cabInvoiceGenerator.rideRepository.put("User01", Arrays.asList(rides));
        try {
            InvoiceSummery invoice = cabInvoiceGenerator.calculateFare("User01");
            InvoiceSummery expectedInvoice = new InvoiceSummery(2, 96.5);
            Assertions.assertEquals(invoice, expectedInvoice);
        }catch (CabInvoiceCustomException e){
            System.out.println(e);
        }
    }

    @Test
    public void givenUserId_WhenINValid_ShouldThrowException() {
        Ride[] rides = {
                new Ride(2.0, 5, "PREMIUM"),
                new Ride(3.1, 5, "PREMIUM")
        };
        cabInvoiceGenerator.rideRepository.put("User01", Arrays.asList(rides));
        try {
            InvoiceSummery invoice = cabInvoiceGenerator.calculateFare("User02");
            InvoiceSummery expectedInvoice = new InvoiceSummery(2, 96.5);
            Assertions.assertEquals(invoice, expectedInvoice);
        }catch (CabInvoiceCustomException e){
            Assertions.assertEquals(CabInvoiceCustomException.ExceptionType.INVALID_USER, e.type);
        }
    }
}