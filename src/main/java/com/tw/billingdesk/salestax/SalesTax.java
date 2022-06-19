package com.tw.billingdesk.salestax;

public interface SalesTax {
    public double calculateTax(double price, double tax, boolean isImported);
}
