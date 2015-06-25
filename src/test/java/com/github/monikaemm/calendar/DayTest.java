package com.github.monikaemm.calendar;

import org.junit.Test;
import java.time.DayOfWeek;
import static org.assertj.core.api.Assertions.assertThat;

public class DayTest {
    @Test
    public void returnsDayOfWeekPassedInConstructor() {
        Day wednesday = new Day(20, DayOfWeek.WEDNESDAY);

        DayOfWeek dayOfWeek = wednesday.getDayOfWeek();

        assertThat(dayOfWeek).isEqualTo(DayOfWeek.WEDNESDAY);
    }

    @Test
    public void returnsDayOfMonthPassedInConstructor() {
        Day wednesday = new Day(17, DayOfWeek.WEDNESDAY);

        int dayOfMonth = wednesday.getDayOfMonth();

        assertThat(dayOfMonth).isEqualTo(17);
    }
}