package com.github.monikaemm.calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;

/**
 * Created by MiluchM on 2015-06-09.
 */
public class WeekView {
    MondayFinder mondayFinder = new MondayFinder();
    public List<Day> getDays() {
        int dayOfMonth = getMonday();

        List<Day> days = new ArrayList<>();
        for (DayOfWeek dow : DayOfWeek.values()) {
            Day day = new Day(dayOfMonth++, dow);
            days.add(day);
        }

        return days;
    }

    private int getMonday() {
        LocalDate today = LocalDate.now();
        LocalDate monday = mondayFinder.findFor(today);
        return monday.getDayOfMonth();
    }
}
