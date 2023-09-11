package com.codecool.model.offers;

import com.codecool.model.products.Product;
import com.codecool.model.discounts.Discount;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record Offer(Product product, LocalDate date, List<Discount> discounts, double price) {

    @Override
    public String toString() {
        return String.format("%s: %s, %s: %s, %s: %s, %s: %s",
                "Product", product,
                "Date", date,
                "Discounts", discounts.stream().map(Object::toString).collect(Collectors.joining(", ")),
                "Price", price);
    }
}