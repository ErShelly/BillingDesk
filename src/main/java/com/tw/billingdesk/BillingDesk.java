package com.tw.billingdesk;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BillingDesk {

    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private static final double ROUND_OFF = 0.05;
    ArrayList<StoreItem> items = new ArrayList<StoreItem>();
    public void addToCart(ItemType itemType, String name, double price, int quantity, Boolean isImported) {
        double calculatedTax = itemType.calculateTax(price, isImported);
        StoreItem item = new StoreItem(itemType, name , price, quantity, isImported, calculatedTax) ;
        items.add(item);
    }

    public void generateReceipt() {
        double totalPrice = Double.valueOf(decimalFormat.format(calculateTotalPrice()));
        double totalSalesTax = Double.valueOf(decimalFormat.format(calculateTotalSalesTax()));
    }

    private double calculateTotalPrice() {
        double totalPrice = 0d;
        for (StoreItem item: items) {
            totalPrice += item.quantity * (item.price + item.tax);
        }
        return totalPrice;
    }

    private double calculateTotalSalesTax() {
        double totalTax = 0d;
        for (StoreItem item: items) {
            totalTax += item.quantity * item.tax;
        }
        return totalTax;
    }
}
