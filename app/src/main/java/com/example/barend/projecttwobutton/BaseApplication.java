package com.example.barend.projecttwobutton;

import android.app.Application;

/**
 * Created by Barend on 2017/05/30.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ServerConfig.init();
    }
}
