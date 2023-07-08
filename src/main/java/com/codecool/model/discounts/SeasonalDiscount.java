package com.codecool.model.discounts;

import com.codecool.model.enums.Season;
import com.codecool.model.enums.SeasonUtils;
import com.codecool.model.products.Product;

import java.time.LocalDate;

public record SeasonalDiscount(Season favoredSeason) implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        Season currentSeason = SeasonUtils.getSeasonFromDate(date);
        if (currentSeason == favoredSeason || currentSeason == favoredSeason.shift(1)) return true;

        Season twoSeasonAfterFavored = favoredSeason.shift(2);
        if (currentSeason == twoSeasonAfterFavored) return true;

        return false;
    }

    @Override
    public String name() {
        return "Seasonal Discount";
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
