package com.tw.billingdesk;

import com.tw.billingdesk.salestax.SalesTax;
import com.tw.billingdesk.salestax.StoreItemTaxCalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BillingDesk {
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    ArrayList<StoreItem> items = new ArrayList<StoreItem>();

    public void addToCart(StoreItem storeItem) {
        items.add(storeItem);
    }

    public void generateReceipt() {
        String receipt = "";
        for (StoreItem item : items) {
            double amount = Double.valueOf(decimalFormat.format(item.price + item.tax));
            receipt += item.quantity + " " + item.name + ": " + amount + "\n";
        }
        double totalSalesTax = Double.valueOf(decimalFormat.format(calculateTotalSalesTax()));
        double totalAmount = Double.valueOf(decimalFormat.format(calculateTotalAmount()));

        receipt += "Sales Taxes: " + totalSalesTax + "\n";
        receipt += "Total: " + totalAmount;
        System.out.println(receipt);
    }

    public double calculateTotalAmount() {
        double totalPrice = 0d;
        for (StoreItem item : items) {
            totalPrice += item.quantity * (item.price + item.tax);
        }
        return totalPrice;
    }

    public double calculateTotalSalesTax() {
        double totalTax = 0d;
        for (StoreItem item : items) {
            totalTax += item.quantity * item.tax;
        }
        return totalTax;
    }

    public double formatDouble(double value) {
        return Double.valueOf(decimalFormat.format(value));
    }
}
