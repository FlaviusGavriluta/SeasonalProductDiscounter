package com.codecool.service.discounts;

import com.codecool.model.discounts.Discount;
import com.codecool.model.offers.Offer;
import com.codecool.model.products.Product;

import java.time.LocalDate;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {
    private final DiscountProvider discountProvider;
    private final DiscountCalculator discountCalculator;

    public DiscountServiceImpl(DiscountProvider discountProvider) {
        this.discountProvider = discountProvider;
        this.discountCalculator = new DiscountCalculator();
    }

    @Override
    public Offer getOffer(Product product, LocalDate date) {
        List<Discount> allDiscounts = discountProvider.getDiscounts();
        List<Discount> applicableDiscounts = discountCalculator.findApplicableDiscounts(product, date, allDiscounts);
        Double discountedPrice = discountCalculator.calculateDiscountedPrice(product, applicableDiscounts);
        return new Offer(product, date, applicableDiscounts, discountedPrice);
    }
}
