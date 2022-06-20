package com.tw.billingdesk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillingDeskTest {
    @Test
    public void testToGenerateReceiptForBookMusicCdAndChocolateBar() {
        BillingDesk billingDesk = new BillingDesk();

        StoreItem book = billingDesk.addToCart(ItemType.Book, "Book", 12.49, 1, false);
        StoreItem musicCd = billingDesk.addToCart(ItemType.Miscellaneous, "music CD", 14.99d, 1, false);
        StoreItem chocolateBar = billingDesk.addToCart(ItemType.Food, "chocolate bar", 0.85, 1, false);

        assertEquals(12.49, billingDesk.formatDouble(book.price + book.tax));
        assertEquals(16.49, billingDesk.formatDouble(musicCd.price + musicCd.tax));
        assertEquals(0.85, billingDesk.formatDouble(chocolateBar.price + chocolateBar.tax));
        assertEquals(1.50, billingDesk.formatDouble(billingDesk.calculateTotalSalesTax()));
        assertEquals(29.83, billingDesk.formatDouble(billingDesk.calculateTotalAmount()));
    }

    @Test
    public void testToGenerateReceiptForImportedChocolatesAndBottleOfPerfume() {
        BillingDesk billingDesk = new BillingDesk();

        StoreItem importedChocolatesBox = billingDesk.addToCart(ItemType.Food, "imported box of chocolates", 10.00, 1, true);
        StoreItem importedPerfume = billingDesk.addToCart(ItemType.Miscellaneous, "imported bottle of perfume", 47.50, 1, true);

        assertEquals(10.50, billingDesk.formatDouble(importedChocolatesBox.price + importedChocolatesBox.tax));
        assertEquals(54.65, billingDesk.formatDouble(importedPerfume.price + importedPerfume.tax));
        assertEquals(7.65, billingDesk.formatDouble(billingDesk.calculateTotalSalesTax()));
        assertEquals(65.15, billingDesk.formatDouble(billingDesk.calculateTotalAmount()));
    }

    @Test
    public void testToGenerateReceiptForImportedChocolatesPerfumeAndPerfumeHeadachePills() {
        BillingDesk billingDesk = new BillingDesk();

        StoreItem importedPerfume = billingDesk.addToCart(ItemType.Miscellaneous, "imported bottle of perfume", 27.99, 1, true);
        StoreItem perfume = billingDesk.addToCart(ItemType.Miscellaneous, "bottle of perfume", 18.99, 1, false);
        StoreItem headachePill = billingDesk.addToCart(ItemType.Medical, "packet of headache pills", 9.75, 1, false);
        StoreItem importedChocolatesBox = billingDesk.addToCart(ItemType.Food, "imported box of chocolates", 11.25, 1, true);

        assertEquals(32.19, billingDesk.formatDouble(importedPerfume.price + importedPerfume.tax));
        assertEquals(20.89, billingDesk.formatDouble(perfume.price + perfume.tax));
        assertEquals(9.75, billingDesk.formatDouble(headachePill.price + headachePill.tax));
        assertEquals(11.85, billingDesk.formatDouble(importedChocolatesBox.price + importedChocolatesBox.tax));
        assertEquals(6.70, billingDesk.formatDouble(billingDesk.calculateTotalSalesTax()));
        assertEquals(74.68, billingDesk.formatDouble(billingDesk.calculateTotalAmount()));
    }
}