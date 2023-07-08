package com.codecool.model.discounts;

import com.codecool.model.enums.Season;
import com.codecool.model.enums.SeasonUtils;
import com.codecool.model.products.Product;

import java.time.LocalDate;

public record OutletDiscount(Season favoredSeason) implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        Season currentSeason = SeasonUtils.getSeasonFromDate(date);
        Season twoSeasonsAfterFavored = favoredSeason.shift(2);
        return currentSeason == twoSeasonsAfterFavored;
    }

    @Override
    public String name() {
        return "Outlet Discount";
    }

    @Override
    public int rate() {
        return 20;
    }

    @Override
    public String toString() {
        return name();
    }
}
