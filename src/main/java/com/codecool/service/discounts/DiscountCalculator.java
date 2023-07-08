package com.codecool.service.discounts;

import com.codecool.model.discounts.Discount;
import com.codecool.model.products.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiscountCalculator {

    public double calculateDiscountedPrice(Product product, List<Discount> discounts) {
        double price = product.price();
        double totalDiscount = 0;

        for (Discount discount : discounts) {
            totalDiscount += (price * discount.rate()) / 100;
        }

        return price - totalDiscount;
    }

    public List<Discount> findApplicableDiscounts(Product product, LocalDate date, List<Discount> allDiscounts) {
        List<Discount> applicableDiscounts = new ArrayList<>();

        for (Discount discount : allDiscounts) {
            if (discount.accepts(product, date)) {
                applicableDiscounts.add(discount);
            }
        }

        return applicableDiscounts;
    }
}
