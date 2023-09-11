package com.codecool.service.discounts;

import com.codecool.model.offers.Offer;
import com.codecool.model.products.Product;

import java.time.LocalDate;


public interface DiscountService {
    Offer getOffer(Product product, LocalDate date);

}