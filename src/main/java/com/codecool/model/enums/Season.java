package com.codecool.model.enums;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

public enum Season {
    SPRING(Set.of(Month.MARCH, Month.APRIL, Month.MAY)),
    SUMMER(Set.of(Month.JUNE, Month.JULY, Month.AUGUST)),
    AUTUMN(Set.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER)),
    WINTER(Set.of(Month.DECEMBER, Month.JANUARY, Month.FEBRUARY));

    private final Set<Month> months;

    Season(Set<Month> months) {
        this.months = months;
    }

    public Set<Month> getMonths() {
        return months;
    }

    public boolean contains(LocalDate date) {
        Month month = date.getMonth();
        for (Season season : Season.values()) {
            if (season.getMonths().contains(month)) return true;
        }
        return false;
    }

    public Season shift(int amount) {
        Season[] seasons = Season.values();
        int currentIndex = this.ordinal();
        int shiftedIndex = (currentIndex + amount) % seasons.length;
        if (shiftedIndex < 0) shiftedIndex += seasons.length;
        return seasons[shiftedIndex];
    }
}
