package com.bridgelabz;

import java.util.Objects;

public class InvoiceSummery {

    int numberOfRides;
    double totalFare;
    double avgFare;

    public InvoiceSummery(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
    }

    public InvoiceSummery(int numberOfRides, double totalFare, String type) {

        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
    }

    public InvoiceSummery getInvoiceSummery() {
        /**
         *  The "this" keyword is used to refer to the current object.
         *  formula = avgFare =totalFare / numberOfRides
         */
        this.avgFare = this.totalFare / this.numberOfRides;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummery that = (InvoiceSummery) o;
        return numberOfRides == that.numberOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.avgFare, avgFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfRides, totalFare, avgFare);
    }
}