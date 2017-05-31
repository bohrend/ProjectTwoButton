package com.example.barend.projecttwobutton;

/**
 * Created by Barend on 2017/05/30.
 */

public class ServerConfig {

    private static String BASE_URL = "";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static void init() {
        BASE_URL = BuildConfig.url; //points to module level build.gradle
    }
}
