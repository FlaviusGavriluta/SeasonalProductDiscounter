package com.codecool.model.discounts;

import com.codecool.model.products.Product;

import java.time.LocalDate;
import java.time.Month;

public record MonthlyDiscount() implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        int month = date.getMonthValue();
        if (month == Month.JUNE.getValue() || month == Month.JULY.getValue()) return true;
        return false;
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
