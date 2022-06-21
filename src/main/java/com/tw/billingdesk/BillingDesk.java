package com.tw.billingdesk;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BillingDesk {
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    ArrayList<StoreItem> items = new ArrayList<>();

    public void addToCart(StoreItem storeItem) {
        items.add(storeItem);
    }

    public void generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        for (StoreItem item : items) {
            double amount = formatDouble(item.price + item.tax);
            receipt.append(item.quantity).append(" ").append(item.name).append(": ").append(amount).append("\n");
        }
        double totalSalesTax = formatDouble(calculateTotalSalesTax());
        double totalAmount = formatDouble(calculateTotalAmount());

        receipt.append("Sales Taxes: ").append(totalSalesTax).append("\n");
        receipt.append("Total: ").append(totalAmount);
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
        return Double.parseDouble(decimalFormat.format(value));
    }
}
