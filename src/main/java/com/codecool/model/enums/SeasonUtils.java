package com.codecool.model.enums;

import java.time.LocalDate;
import java.time.Month;

public class SeasonUtils {
    public static Season getSeasonFromDate(LocalDate date) {
        Month month = date.getMonth();
        for (Season season : Season.values()) {
            if (season.getMonths().contains(month)) return season;
        }
        throw new IllegalArgumentException("Invalid date provided,");
    }
}
