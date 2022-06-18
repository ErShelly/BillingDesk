package com.tw.billingdesk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillingDeskTest {
    @Test
    public void ableToAddItemsToCart(){
        BillingDesk billingDesk = new BillingDesk();
        billingDesk.addToCart(ItemType.Book, "Book", 12.49, 1, false);
        billingDesk.addToCart(ItemType.Miscellaneous, "music CD", 14.99, 1, false);
        billingDesk.addToCart(ItemType.Food, "chocolate bar", 0.85, 1, false);
        billingDesk.generateReceipt();
    }
}