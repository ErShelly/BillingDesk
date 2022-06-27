package com.tw.billingdesk;

import com.tw.billingdesk.salestax.SalesTaxConstants;

public class ItemType {
    private final double basicTax;

    private ItemType(double basicTax) {
        this.basicTax = basicTax;
    }

    public static final ItemType Book = new ItemType(SalesTaxConstants.BOOK_TAX);
    public static final ItemType Food = new ItemType(SalesTaxConstants.FOOD_TAX);
    public static final ItemType Medical = new ItemType(SalesTaxConstants.MEDICAL_TAX);
    public static final ItemType Miscellaneous = new ItemType(SalesTaxConstants.MISCELLANEOUS_TAX);

    public double getBasicTax() {
        return basicTax;
    }
}
