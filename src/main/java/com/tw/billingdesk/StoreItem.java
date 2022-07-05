package com.tw.billingdesk;

import com.tw.billingdesk.salestax.SalesTaxCalculator;

public class StoreItem {
    public ItemType type;
    public String name;
    public double price;
    public int quantity;
    public Boolean isImported;
    public double tax;
    public double totalTax;
    public double totalAmount;

    SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator();

    public StoreItem(ItemType type, String name, double price, int quantity, Boolean isImported) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isImported = isImported;

        this.tax = salesTaxCalculator.calculateTax(price, type.getBasicTax(), isImported);
        this.totalAmount = quantity * (price + this.tax);
        this.totalTax = quantity * this.tax;
    }
}
