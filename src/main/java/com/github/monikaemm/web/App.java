package com.github.monikaemm.web;

import com.github.monikaemm.calendar.TasksRepository;
import com.github.monikaemm.calendar.WeekView;
import com.google.gson.Gson;
import spark.Request;
import spark.ResponseTransformer;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

/**
 * Created by MiluchM on 2015-06-25.
 */
public class App {
    static Gson gson = new Gson();
    static TasksRepository tasksRepo = new TasksRepository();

    public static void main(String[] args) {
        WeekView week = new WeekView();
        tasksRepo.addTask(LocalDate.now(), "zadanie");
        tasksRepo.addTask(LocalDate.now(), "zadanie 2 ");
        tasksRepo.addTask(LocalDate.now(), "zadanie 3");
        tasksRepo.addTask(LocalDate.of(2015,7,28), "zadanie 3");

        staticFileLocation("app");
        get("/currentWeek", (req, res) -> week.getDays(), toJson());
        get("/task", (req, res) -> getTasks(req), toJson());
    }

    private static List<String> getTasks(Request req) {
        String dayFilter = req.queryParams("day");
        LocalDate requestDay = getDateInCurrentMonth(dayFilter);
        return tasksRepo.getTasksFor(requestDay);
    }

    private static LocalDate getDateInCurrentMonth(String dayString) {
        int dayOfMonth = Integer.parseInt(dayString);
        LocalDate currentDate = LocalDate.now();
        return currentDate.withDayOfMonth(dayOfMonth);
    }

    private static ResponseTransformer toJson() {
        return o -> gson.toJson(o);
    }
}
