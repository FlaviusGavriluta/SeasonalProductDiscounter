package com.codecool.service.discounts;

import com.codecool.model.discounts.Discount;

import java.util.List;

public interface DiscountProvider {
    List<Discount> getDiscounts();
}
