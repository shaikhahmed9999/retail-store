package com.store.retail.constants;

public enum Discounts {
	NOT_GROCERY(0.05),
    CUSTOMER(0.05),
    AFFILIATE(0.1),
    EMPLOYEE(0.3);

    private final double discount;

    Discounts(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
