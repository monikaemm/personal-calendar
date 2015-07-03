package com.github.monikaemm.web;

import static spark.Spark.*;

/**
 * Created by MiluchM on 2015-06-25.
 */
public class App {
    public static void main(String[] args) {
        staticFileLocation("app");
        get("/hello", (req, res) -> "Monika");
    }
}
