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
        billingDesk.addToCart(ItemType.Miscellaneous, "imported bottle of perfume", 47.50, 1, true);
        billingDesk.generateReceipt();
    }

    @Test
    public void generateReceiptForInput3(){
        BillingDesk billingDesk = new BillingDesk();
        billingDesk.addToCart(ItemType.Miscellaneous, "imported bottle of perfume", 27.99, 1, true);
        billingDesk.addToCart(ItemType.Miscellaneous, "bottle of perfume", 18.99, 1, true);
        billingDesk.addToCart(ItemType.Medical, "packet of headache pills", 9.75, 1, false);
        billingDesk.addToCart(ItemType.Food, "imported box of chocolates", 11.25, 1, true);
        billingDesk.generateReceipt();
    }
}