package com.codecool;

import com.codecool.service.discounts.DiscountProvider;
import com.codecool.service.discounts.DiscountService;
import com.codecool.service.products.ProductProvider;
import com.codecool.service.products.ProductProviderImpl;
import com.codecool.ui.SeasonalProductDiscounterUi;

public class Application {
    public static void main(String[] args) {
        ProductProvider productProvider = new ProductProviderImpl();
        DiscountProvider discountProvider = null;
        DiscountService discounterService = null;
        SeasonalProductDiscounterUi ui = new SeasonalProductDiscounterUi(productProvider,
                discountProvider, discounterService);
        ui.run();
    }
}
