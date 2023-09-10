package com.codecool.model.discounts;

import com.codecool.model.enums.Season;
import com.codecool.model.products.Product;

import java.time.LocalDate;

public record SeasonalDiscount(String name, int rate, int seasonShift) implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        Season shiftedSeason = product.season().shift(seasonShift);
        return shiftedSeason.contains(date);
    }

    @Override
    public String toString() {
        return "SeasonalDiscount{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", favoredSeason=" + seasonShift +
                '}';
    }
}