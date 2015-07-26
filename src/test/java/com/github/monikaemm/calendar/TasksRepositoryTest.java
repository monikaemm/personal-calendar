package com.github.monikaemm.calendar;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by MiluchM on 2015-07-15.
 */
public class TasksRepositoryTest {
    TasksRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = new TasksRepository();
    }

    @Test
    public void returnsEmptyListForEmptyRepository() {
        LocalDate day = LocalDate.of(2015, 7, 15);

        List<String> tasks = repository.getTasksFor(day);

        assertThat(tasks).isEmpty();
    }

    @Test
    public void returnsTaskPreviouslySetForGivenDay() {
        LocalDate day = LocalDate.of(2015, 1, 1);
        String task = "create new year resolution";

        repository.addTask(day, task);
        List<String> tasks = repository.getTasksFor(day);

        assertThat(tasks).containsOnly(task);
    }

    @Test
    public void returnsEmptyListIfTasksWereNotSetForThisDay() {
        LocalDate day = LocalDate.of(2015, 1, 1);
        LocalDate otherDay = LocalDate.of(2015, 6, 20);
        String task = "create new year resolution";

        repository.addTask(day, task);
        List<String> tasks = repository.getTasksFor(otherDay);

        assertThat(tasks).isEmpty();
    }

    @Test
    public void returnsAllTasksSetForGivenDay() {
        LocalDate day = LocalDate.of(2015, 1, 1);
        String task1 = "create new year resolution";
        String task2 = "clean up the mess";

        repository.addTask(day, task1);
        repository.addTask(day, task2);
        List<String> tasks = repository.getTasksFor(day);

        assertThat(tasks).containsOnly(task1, task2);
    }
}
