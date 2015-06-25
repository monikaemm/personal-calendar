package com.github.monikaemm.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by MiluchM on 2015-06-17.
 */
public class MondayFinder {
    public LocalDate findFor(LocalDate day) {
        DayOfWeek dayOfWeek = day.getDayOfWeek();
        int daysToBack = dayOfWeek.getValue() - 1;
        return day.minusDays(daysToBack);
    }
}
