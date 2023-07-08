package com.codecool.model.discounts;

import com.codecool.model.products.Product;

import java.time.LocalDate;

public record MonthlyDiscount() implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        int month = date.getMonthValue();
        return month == 6 || month == 7; // June and July
    }

    @Override
    public String name() {
        return "Monthly Discount";
    }

    @Override
    public int rate() {
        return 10;
    }

    @Override
    public String toString() {
        return name();
    }
}
