package com.codecool.model.products;

import com.codecool.model.enums.Color;
import com.codecool.model.enums.Season;


public record Product(String name, Color color, Season season, double price) {

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", season=" + season +
                ", price=" + price +
                '}';
    }
}

