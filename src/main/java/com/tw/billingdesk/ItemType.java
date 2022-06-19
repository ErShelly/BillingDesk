package com.tw.billingdesk;

import com.tw.billingdesk.salestax.StoreItemConstants;

public class ItemType {
    private final double basicTax;

    private ItemType(double basicTax) {
        this.basicTax = basicTax;
    }

    public static final ItemType Book = new ItemType(StoreItemConstants.BOOK_TAX);
    public static final ItemType Food = new ItemType(StoreItemConstants.FOOD_TAX);
    public static final ItemType Medical = new ItemType(StoreItemConstants.MEDICAL_TAX);
    public static final ItemType Miscellaneous = new ItemType(StoreItemConstants.MISCELLANEOUS_TAX);

    public double getBasicTax() {
        return basicTax;
    }
}
