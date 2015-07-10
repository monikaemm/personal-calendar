package com.github.monikaemm.web;

import com.github.monikaemm.calendar.WeekView;
import com.google.gson.Gson;
import spark.ResponseTransformer;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

/**
 * Created by MiluchM on 2015-06-25.
 */
public class App {
    static Gson gson = new Gson();
    public static void main(String[] args) {
        WeekView week = new WeekView();

        staticFileLocation("app");
        get("/currentWeek", (req, res) -> week.getDays(), toJson());
    }

    private static ResponseTransformer toJson() {
        return o -> gson.toJson(o);
    }
}
