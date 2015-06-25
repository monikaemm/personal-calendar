package com.github.monikaemm.calendar;

import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by MiluchM on 2015-06-17.
 */
public class MondayFinderTest {
    static final LocalDate monday = LocalDate.of(2015, 6, 15);
    static final LocalDate tuesday = LocalDate.of(2015, 6, 16);
    static final LocalDate wednesday = LocalDate.of(2015, 6, 17);

    MondayFinder finder;

    @Before
    public void setUp() throws Exception {
        finder=new MondayFinder();
    }

    @Test
    public void givenMonday_returnsTheSameDate() {
        LocalDate found = finder.findFor(monday);

        assertThat(found).isEqualTo(monday);
    }

    @Test
    public void givenTuesday_returnsMonday() {
        LocalDate found = finder.findFor(tuesday);

        assertThat(found.getDayOfWeek()).isEqualTo(DayOfWeek.MONDAY);
    }

    @Test
    public void givenAnyDay_returnsClosestMondayPrecedingThisDay() {
        LocalDate found = finder.findFor(wednesday);

        assertThat(found).isEqualTo(monday);
    }
}
