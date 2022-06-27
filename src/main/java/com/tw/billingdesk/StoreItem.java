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


    private StoreItem(ItemType type, String name, double price, int quantity, Boolean isImported, double tax, double totalTax, double totalAmount) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isImported = isImported;
        this.tax = tax;
        this.totalTax = totalTax;
        this.totalAmount = totalAmount;
    }

    public static StoreItem createStoreItem(ItemType type, String name, double price, int quantity, Boolean isImported) {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator();

        double tax = salesTaxCalculator.calculateTax(price, type.getBasicTax(), isImported);
        double totalAmount = quantity * (price + tax);
        double totalTax = quantity * tax;

        return new StoreItem(type, name, price, quantity, isImported, tax, totalTax, totalAmount);
    }
}
