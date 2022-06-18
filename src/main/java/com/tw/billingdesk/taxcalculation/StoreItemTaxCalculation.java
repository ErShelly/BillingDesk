package com.tw.billingdesk.taxcalculation;

import java.text.DecimalFormat;

public class StoreItemTaxCalculation implements TaxCalculation{
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    public double calculateTax(double price, double tax, boolean isImported) {
        double totalTax = price * tax + (isImported ? price * StoreItemTaxConstants.IMPORT_DUTY_TAX : 0);
        return Double.valueOf(decimalFormat.format(totalTax));
    }
}
