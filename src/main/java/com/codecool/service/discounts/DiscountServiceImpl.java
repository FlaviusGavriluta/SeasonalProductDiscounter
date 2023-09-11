package com.codecool.service.discounts;

import com.codecool.model.discounts.Discount;
import com.codecool.model.offers.Offer;
import com.codecool.model.products.Product;
import com.codecool.service.logger.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountServiceImpl implements DiscountService {
    private final DiscountProvider discountProvider;
    private final Logger logger;

    public DiscountServiceImpl(DiscountProvider discountProvider, Logger logger) {
        this.discountProvider = discountProvider;
        this.logger = logger;
    }

    @Override
    public Offer getOffer(Product product, LocalDate date) {
        logger.logInfo("Calculating offer for product: " + product.name());
        List<Discount> applicableDiscounts = findApplicableDiscounts(product, date);
        double discountedPrice = calculateDiscountedPrice(product.price(), applicableDiscounts);
        Offer offer = new Offer(product, date, applicableDiscounts, discountedPrice);
        logger.logInfo("Offer calculated: " + offer);
        return offer;
    }

    private List<Discount> findApplicableDiscounts(Product product, LocalDate date) {
        return discountProvider.getDiscounts().stream()
                .filter(discount -> discount.accepts(product, date))
                .peek(discount -> logger.logInfo("Applicable discount found: " + discount.name()))
                .collect(Collectors.toList());
    }

    private double calculateDiscountedPrice(double originalPrice, List<Discount> discounts) {
        return discounts.stream()
                .reduce(originalPrice,
                        (price, discount) -> {
                            double newPrice = price - (price * discount.rate() / 100);
                            logger.logInfo("Applied discount: " + discount.name() + ", new price: " + newPrice);
                            return newPrice;
                        },
                        Double::sum);
    }
}