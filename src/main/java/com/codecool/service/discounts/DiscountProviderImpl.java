package com.codecool.service.discounts;

import com.codecool.model.discounts.*;
import com.codecool.model.enums.Color;
import com.codecool.model.enums.Season;
import com.codecool.service.logger.Logger;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiscountProviderImpl implements DiscountProvider {
    private final List<Discount> discounts;
    private final Logger logger;

    public DiscountProviderImpl(Logger logger) {
        this.logger = logger;
        this.discounts = new ArrayList<>();
        this.discounts.add(new MonthlyDiscount("Summer Kick-off", 10, new HashSet<>(Set.of(Month.JUNE, Month.JULY))));
        this.discounts.add(new MonthlyDiscount("Winter Sale", 10, new HashSet<>(Set.of(Month.FEBRUARY))));
        this.discounts.add(new ColorDiscount("Blue Winter", 5, Color.BLUE, Season.WINTER));
        this.discounts.add(new ColorDiscount("Green Spring", 5, Color.GREEN, Season.SPRING));
        this.discounts.add(new ColorDiscount("Yellow Summer", 5, Color.YELLOW, Season.SUMMER));
        this.discounts.add(new ColorDiscount("Brown Autumn", 5, Color.BROWN, Season.AUTUMN));
        this.discounts.add(new SeasonalDiscount("Sale Discount", 10, -1));
        this.discounts.add(new SeasonalDiscount("Sale Discount", 10, 1));
        this.discounts.add(new SeasonalDiscount("Outlet Discount", 20, 2));
        logger.logInfo("DiscountProviderImpl initialized and discounts added.");
    }

    @Override
    public List<Discount> getDiscounts() {
        logger.logInfo("getDiscounts() called.");
        return this.discounts;
    }
}