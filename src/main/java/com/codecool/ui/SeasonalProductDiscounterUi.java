package com.codecool.ui;

import com.codecool.model.discounts.ColorDiscount;
import com.codecool.model.discounts.Discount;
import com.codecool.model.offers.Offer;
import com.codecool.model.products.Product;
import com.codecool.service.discounts.DiscountProvider;
import com.codecool.service.discounts.DiscountService;
import com.codecool.service.logger.ConsoleLogger;
import com.codecool.service.products.ProductProvider;


import static java.lang.System.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeasonalProductDiscounterUi {
    private final ProductProvider productProvider;
    private final DiscountProvider discountProvider;
    private final DiscountService discountService;
    private final Scanner scanner;

    public SeasonalProductDiscounterUi(
            ProductProvider productProvider,
            DiscountProvider discountProvider,
            DiscountService discounterService) {
        this.productProvider = productProvider;
        this.discountProvider = discountProvider;
        this.discountService = discounterService;
        this.scanner = new Scanner(in);
    }

    public void run() {
        out.println("Welcome to Seasonal Product Discounter!\n");

        printCatalog();
        printPromotions();

        out.println("Enter a date to see which products are discounted on that date:");
        LocalDate date = getDate();
        out.println();

        printOffers(date);
    }

    private LocalDate getDate() {
        while (true) {
            out.println("Enter a date (YYYY-MM-DD): ");
            String input = scanner.nextLine();
            try {
                return LocalDate.parse(input);
            } catch (Exception e) {
                out.println("Invalid date format. Please try again.");
            }
        }
    }

    private void printCatalog() {
        out.println("Product Catalog: ");
        List<Product> products = productProvider.getProducts();
        for (Product product : products) {
            out.println(product);
        }
        out.println();
    }

    private void printPromotions() {
        out.println("Available Promotions");
        List<Discount> discounts = discountProvider.getDiscounts();
        for (Discount discount : discounts) {
            out.println(discount);
        }
        out.println();
    }

    private void printOffers(LocalDate date) {
        out.println("Offers for " + date + ": ");
        List<Product> products = productProvider.getProducts();
        for (Product product : products) {
            Offer offer = discountService.getOffer(product, date);
            if (!offer.discounts().isEmpty()) out.println(offer);
        }
    }

    private List<Offer> getOffers(LocalDate date) {
        List<Offer> discounted = new ArrayList<>();

        for (Product product : productProvider.getProducts()) {
            Offer offer = discountService.getOffer(product, date);
            if (!offer.discounts().isEmpty()) {
                discounted.add(offer);
            }
        }

        return discounted;
    }
}