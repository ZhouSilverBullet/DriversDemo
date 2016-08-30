package com.qianphone.driversdemo.utils;

import android.content.Context;

/**
 * Created by 周周 on 2016/8/26.
 */
public class SpUtils {


    public static void setBoolean(String key,boolean values){
        DriversApplication.getContext().getSharedPreferences(ConstantValue.STATE,
                Context.MODE_PRIVATE).edit().putBoolean(key,values).apply();

    }
    public static boolean getBoolean(String key,boolean defValues){
        boolean aBoolean = DriversApplication.getContext().getSharedPreferences(ConstantValue.STATE,
                Context.MODE_PRIVATE).getBoolean(key, defValues);
        return aBoolean;
    }

}
