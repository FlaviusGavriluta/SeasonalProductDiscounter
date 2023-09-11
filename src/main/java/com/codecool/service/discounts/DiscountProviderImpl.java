package com.codecool.service.discounts;

import com.codecool.model.discounts.ColorDiscount;
import com.codecool.model.discounts.Discount;
import com.codecool.model.discounts.MonthlyDiscount;
import com.codecool.model.discounts.SeasonalDiscount;
import com.codecool.model.enums.Color;
import com.codecool.model.enums.Season;
import com.codecool.service.logger.Logger;

import java.time.Month;
import java.util.List;
import java.util.Set;

public class DiscountProviderImpl implements DiscountProvider {
    private final List<Discount> discounts;
    private final Logger logger;

    public DiscountProviderImpl(Logger logger) {
        this.logger = logger;
        this.discounts = generateDiscounts();
        logger.logInfo("DiscountProviderImpl initialized and discounts added.");
    }

    private static List<Discount> generateDiscounts() {
        return List.of(
                new MonthlyDiscount("Summer Kick-off", 10, Set.of(Month.JUNE, Month.JULY)),
                new MonthlyDiscount("Winter Sale", 10, Set.of(Month.FEBRUARY)),
                new ColorDiscount("Blue Winter", 5, Color.BLUE, Season.WINTER),
                new ColorDiscount("Green Spring", 5, Color.GREEN, Season.SPRING),
                new ColorDiscount("Yellow Summer", 5, Color.YELLOW, Season.SUMMER),
                new ColorDiscount("Brown Autumn", 5, Color.BROWN, Season.AUTUMN),
                new SeasonalDiscount("Sale Discount", 10, -1),
                new SeasonalDiscount("Sale Discount", 10, 1),
                new SeasonalDiscount("Outlet Discount", 20, 2)
        );
    }

    @Override
    public List<Discount> getDiscounts() {
        logger.logInfo("getDiscounts() called.");
        return this.discounts;
    }
}