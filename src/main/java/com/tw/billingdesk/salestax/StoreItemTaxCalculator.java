package com.tw.billingdesk.salestax;

import java.text.DecimalFormat;

public class StoreItemTaxCalculator implements SalesTax {
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private final double ROUND_OFF = 0.05;

    @Override
    public double calculateTax(double price, double tax, boolean isImported) {
        double totalTax = price * tax + (isImported ? price * StoreItemConstants.IMPORT_DUTY_TAX : 0);
        totalTax = roundOff(totalTax);
        return Double.valueOf(decimalFormat.format(totalTax));
    }

    private double roundOff(double value) {
        return Math.ceil(value / ROUND_OFF) * ROUND_OFF;
    }
}
