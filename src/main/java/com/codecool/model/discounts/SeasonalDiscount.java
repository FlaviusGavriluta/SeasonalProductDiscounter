package com.codecool.model.discounts;

import com.codecool.model.enums.Season;
import com.codecool.model.enums.SeasonUtils;
import com.codecool.model.products.Product;

import java.time.LocalDate;

public record SeasonalDiscount(Season favoredSeason) implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        Season currentSeason = SeasonUtils.getSeasonFromDate(date);
        return currentSeason == favoredSeason || currentSeason == favoredSeason.shift(1);
    }

    @Override
    public String name() {
        return "Sale Discount";
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