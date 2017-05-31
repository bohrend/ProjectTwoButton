package com.example.barend.projecttwobutton;

import android.app.Application;

/**
 * Created by Barend on 2017/05/30.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //entire apps settings will be configured here, for now only serverconfig
        ServerConfig.init();
    }
}
