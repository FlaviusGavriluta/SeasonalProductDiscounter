package com.codecool.model.discounts;

import com.codecool.model.enums.Color;
import com.codecool.model.enums.Season;
import com.codecool.model.products.Product;

import java.time.LocalDate;

public record ColorDiscount(String name, int rate, Color color, Season season) implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        return color.equals(product.color()) && season.contains(date);
    }

    @Override
    public String toString() {
        return "ColorDiscount{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", color=" + color +
                ", season=" + season +
                '}';
    }
}