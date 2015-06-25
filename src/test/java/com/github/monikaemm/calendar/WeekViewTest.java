package com.github.monikaemm.calendar;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.time.DayOfWeek;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by MiluchM on 2015-06-09.
 */
public class WeekViewTest {

    private final MondayFinder mondayFinder = new MondayFinder();
    private WeekView view;

    @Before
    public void setUp() throws Exception {
        view = new WeekView();
    }

    @Test
    public void returnsListOfSevenDays() {
        List<Day> days = view.getDays();

        assertThat(days).hasSize(7);
    }

    @Test
    public void firstDayIsMonday() {
        List<Day> days = view.getDays();

        Day firstDay = days.get(0);
        assertThat(firstDay.getDayOfWeek()).isEqualTo(DayOfWeek.MONDAY);
    }

    @Test
    public void lastDayIsSunday() {
        List<Day> days = view.getDays();

        Day lastDay = days.get(6);
        assertThat(lastDay.dayOfWeek).isEqualTo(DayOfWeek.SUNDAY);
    }

    @Test
    public void firstDayIsMondayClosestToToday() {
        List<Day> days = view.getDays();

        int expectedDay = findMonday();
        Day firstDay = days.get(0);
        assertThat(firstDay.getDayOfMonth()).isEqualTo(expectedDay);
    }

    @Test
    public void thirdDayOfMonthIsGreaterThanFirst() {
        List<Day> days = view.getDays();

        Day firstDay = days.get(0);
        Day thirdDay = days.get(2);
        assertThat(thirdDay.getDayOfMonth()).isEqualTo(firstDay.getDayOfMonth() + 2);
    }

    private int findMonday() {
        LocalDate monday = mondayFinder.findFor(LocalDate.now());
        return monday.getDayOfMonth();
    }
}
