package com.tw.billingdesk;

public class ItemType {
    private final double basicTax;
    private final double importedTax;

    private ItemType(double basicTax, double importedTax) {
        this.basicTax = basicTax;
        this.importedTax = importedTax;
    }

    public static final ItemType Book = new ItemType(0d, 0.05d);
    public static final ItemType Food = new ItemType(0d, 0.05d);
    public static final ItemType Medical = new ItemType(0d, 0.05d);
    public static final ItemType Miscellaneous = new ItemType(0.1d, 0.05d);

    public double calculateTax(double price, boolean isImported) {
        double importDutyTax = isImported ? basicTax * importedTax : 0d;
        return (basicTax * price + importDutyTax);
    }
}
