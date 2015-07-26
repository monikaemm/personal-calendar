package com.github.monikaemm.calendar;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MiluchM on 2015-07-21.
 */
public class TasksRepository {

    Map<LocalDate, List<String>> tasksForDays = new HashMap<>();

    public List<String> getTasksFor(LocalDate day) {
        if (!tasksForDays.containsKey(day)) {
            tasksForDays.put(day, new ArrayList<>());
        }
        return tasksForDays.get(day);
    }

    public void addTask(LocalDate day, String task) {
        List<String> tasks = getTasksFor(day);
        tasks.add(task);
    }
}
