package com.example.barend.projecttwobutton.enums;

/**
 * Created by Barend on 2017/05/30.
 */

public enum HttpMethod {

    GET("GET"),
    POST("POST");

    private final String mName;

    private HttpMethod(String s) {
        this.mName = s;
    }

    public String toString() {
        return this.mName;
    }
}
