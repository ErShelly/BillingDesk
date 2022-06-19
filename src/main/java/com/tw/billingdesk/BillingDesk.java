package com.tw.billingdesk;

import com.tw.billingdesk.salestax.SalesTax;
import com.tw.billingdesk.salestax.StoreItemTaxCalculation;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BillingDesk {

    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    private SalesTax salesTax = new StoreItemTaxCalculation();
    ArrayList<StoreItem> items = new ArrayList<StoreItem>();

    public void addToCart(ItemType itemType, String name, double price, int quantity, Boolean isImported) {
        double tax = salesTax.calculateTax(price, itemType.getBasicTax(), isImported);
        StoreItem item = new StoreItem(itemType, name, price, quantity, isImported, tax);
        items.add(item);
    }

    public void generateReceipt() {
        String receipt = "";
        for (StoreItem item : items) {
            receipt += item.quantity + " " + item.name + ": " + (item.price + item.tax) + "\n";
        }
        double totalSalesTax = Double.valueOf(decimalFormat.format(calculateTotalSalesTax()));
        double totalAmount = Double.valueOf(decimalFormat.format(calculateTotalAmount()));

        receipt += "Sales Taxes: " + totalSalesTax + "\n";
        receipt += "Total: " + totalAmount;
    }

    private double calculateTotalAmount() {
        double totalPrice = 0d;
        for (StoreItem item : items) {
            totalPrice += item.quantity * (item.price + item.tax);
        }
        return totalPrice;
    }

    private double calculateTotalSalesTax() {
        double totalTax = 0d;
        for (StoreItem item : items) {
            totalTax += item.quantity * item.tax;
        }
        return totalTax;
    }
}
