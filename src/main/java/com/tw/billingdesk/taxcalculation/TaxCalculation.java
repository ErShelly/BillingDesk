package com.tw.billingdesk.taxcalculation;

public interface TaxCalculation {
    public double calculateTax(double price, double tax, boolean isImported);
}
