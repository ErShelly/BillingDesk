package com.tw.billingdesk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillingDeskTest {
    @Test
    public void generateReceiptForInput1(){
        BillingDesk billingDesk = new BillingDesk();
        billingDesk.addToCart(ItemType.Book, "Book", 12.49, 1, false);
        billingDesk.addToCart(ItemType.Miscellaneous, "music CD", 14.99, 1, false);
        billingDesk.addToCart(ItemType.Food, "chocolate bar", 0.85, 1, false);
        billingDesk.generateReceipt();
    }

    @Test
    public void generateReceiptForInput2(){
        BillingDesk billingDesk = new BillingDesk();
        billingDesk.addToCart(ItemType.Food, "imported box of chocolates", 10.00, 1, true);
        billingDesk.addToCart(ItemType.Miscellaneous, "imported box of perfume", 47.50, 1, true);
        billingDesk.generateReceipt();
    }
}