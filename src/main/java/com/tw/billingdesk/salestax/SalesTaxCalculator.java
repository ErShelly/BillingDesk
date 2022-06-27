package com.tw.billingdesk.salestax;

import java.text.DecimalFormat;

public class SalesTaxCalculator {
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private final double ROUND_OFF = 0.05;

    public double calculateTax(double price, double tax, boolean isImported) {
        double totalTax = price * tax + (isImported ? price * SalesTaxConstants.IMPORT_DUTY_TAX : 0);
        totalTax = roundOff(totalTax);
        return Double.parseDouble(decimalFormat.format(totalTax));
    }

    private double roundOff(double value) {
        return Math.ceil(value / ROUND_OFF) * ROUND_OFF;
    }
}
