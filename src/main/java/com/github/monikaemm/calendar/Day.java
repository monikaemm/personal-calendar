package com.github.monikaemm.calendar;
import java.time.DayOfWeek;
/**
 * Created by MiluchM on 2015-06-09.
 */
public class Day {
    DayOfWeek dayOfWeek;
    int dayOfMonth;
    boolean weekend;

    public Day(int dayOfMonth, DayOfWeek dayOfWeek) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.weekend = dayOfWeek == DayOfWeek.SUNDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }
}
