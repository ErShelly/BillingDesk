package com.tw.billingdesk;

import com.tw.billingdesk.salestax.SalesTaxCalculator;

public class StoreItem {
    public ItemType type;
    public String name;
    public double price;
    public int quantity;
    public Boolean isImported;
    public double tax;


    public StoreItem(ItemType type, String name, double price, int quantity, Boolean isImported, double tax){
        this.type = type;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isImported = isImported;
        this.tax = tax;
    }


    public static StoreItem createStoreItem(ItemType type, String name, double price, int quantity, Boolean isImported){
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator();

        double tax = salesTaxCalculator.calculateTax(price, type.getBasicTax(), isImported);
        return new StoreItem(type, name, price, quantity, isImported, tax);
    }
}
