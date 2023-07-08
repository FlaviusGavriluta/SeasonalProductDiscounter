package com.codecool.service.discounts;

import com.codecool.model.discounts.Discount;
import com.codecool.model.offers.Offer;
import com.codecool.model.products.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {
    private final DiscountProvider discountProvider;

    public DiscountServiceImpl(DiscountProvider discountProvider) {
        this.discountProvider = discountProvider;
    }

    @Override
    public Offer getOffer(Product product, LocalDate date) {
        List<Discount> applicableDiscounts = findApplicableDiscounts(product, date);
        Double discountedPrice = calculateDiscountedPrice(product, applicableDiscounts);
        return new Offer(product, date, applicableDiscounts, discountedPrice);
    }

    private List<Discount> findApplicableDiscounts(Product product, LocalDate date) {
        List<Discount> allDiscounts = discountProvider.getDiscounts();
        List<Discount> applicableDiscounts = new ArrayList<>();

        for (Discount discount : allDiscounts) {
            if (discount.accepts(product, date)) {
                applicableDiscounts.add(discount);
            }
        }

        return applicableDiscounts;
    }

    private double calculateDiscountedPrice(Product product, List<Discount> discounts) {
        double price = product.price();
        double totalDiscount = 0;

        for (Discount discount : discounts) {
            totalDiscount += (price * discount.rate()) / 100;
        }

        return price - totalDiscount;
    }
}
