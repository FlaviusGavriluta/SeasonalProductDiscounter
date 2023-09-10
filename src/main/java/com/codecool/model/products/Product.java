package com.codecool.model.products;

import com.codecool.model.enums.Color;
import com.codecool.model.enums.Season;

public record Product(int id, String name, Color color, Season season, double price) {
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", season=" + season +
                ", price=" + price +
                '}';
    }
}