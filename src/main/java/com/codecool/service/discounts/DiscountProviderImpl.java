package com.codecool.service.discounts;

import com.codecool.model.discounts.*;
import com.codecool.model.enums.Season;

import java.util.ArrayList;
import java.util.List;

public class DiscountProviderImpl implements DiscountProvider{
    private final List<Discount> discounts;
    public DiscountProviderImpl() {
        discounts = new ArrayList<>();
        discounts.add(new MonthlyDiscount());
        discounts.add(new ColorDiscount());
        discounts.add(new SeasonalDiscount(Season.SUMMER));
        discounts.add(new SeasonalDiscount(Season.WINTER));
    }
    @Override
    public List<Discount> getDiscounts() {
        return discounts;
    }
}
