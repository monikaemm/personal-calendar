package com.github.monikaemm.calendar;
import java.time.DayOfWeek;
/**
 * Created by MiluchM on 2015-06-09.
 */
public class Day {
    DayOfWeek dayOfWeek;
    int dayOfMonth;

    public Day(int dayOfMonth, DayOfWeek dayOfWeek) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }
}
