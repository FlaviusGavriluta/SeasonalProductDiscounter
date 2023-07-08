package com.codecool.model.discounts;

import com.codecool.model.enums.Color;
import com.codecool.model.enums.Season;
import com.codecool.model.products.Product;
import com.codecool.model.enums.SeasonUtils;

import java.time.LocalDate;

public record ColorDiscount() implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        Season season = SeasonUtils.getSeasonFromDate(date);
        Color productColor = product.color();

        if (season == Season.WINTER) return productColor == Color.BLUE;
        else if (season == Season.SPRING) return productColor == Color.GREEN;
        else if (season == Season.SUMMER) return productColor == Color.YELLOW;
        else if (season == Season.AUTUMN) return productColor == Color.BROWN;
        return false;
    }

    @Override
    public String name() {
        return "Color Discount";
    }

    @Override
    public int rate() {
        return 5;
    }

    @Override
    public String toString() {
        return name();
    }
}
