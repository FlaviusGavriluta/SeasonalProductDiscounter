package com.codecool;

import com.codecool.service.discounts.DiscountProvider;
import com.codecool.service.discounts.DiscountProviderImpl;
import com.codecool.service.discounts.DiscountService;
import com.codecool.service.discounts.DiscountServiceImpl;
import com.codecool.service.logger.ConsoleLogger;
import com.codecool.service.logger.Logger;
import com.codecool.service.products.ProductProvider;
import com.codecool.service.products.ProductProviderImpl;
import com.codecool.ui.SeasonalProductDiscounterUi;

public class Application {
    public static void main(String[] args) {
        ProductProvider productProvider = new ProductProviderImpl();
        Logger logger = new ConsoleLogger();
        DiscountProvider discountProvider = new DiscountProviderImpl(logger);
        DiscountService discounterService = new DiscountServiceImpl(discountProvider, logger);
        SeasonalProductDiscounterUi ui = new SeasonalProductDiscounterUi(productProvider,
                discountProvider, discounterService);
        ui.run();
    }
}