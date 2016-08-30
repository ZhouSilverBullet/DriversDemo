package com.qianphone.driversdemo.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by 周周 on 2016/8/25.
 */
public class DriversApplication extends Application {
    public static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext =getApplicationContext();
    }

    public static Context getContext(){
        return sContext;
    }
}
