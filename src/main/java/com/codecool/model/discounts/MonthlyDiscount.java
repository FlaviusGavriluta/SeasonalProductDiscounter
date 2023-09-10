package com.codecool.model.discounts;

import com.codecool.model.products.Product;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

public record MonthlyDiscount(String name, int rate, Set<Month> months) implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        return months.stream().anyMatch(month -> month.getValue() == date.getMonthValue());
    }

    @Override
    public String toString() {
        return "MonthlyDiscount{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", months=" + months +
                '}';
    }
}