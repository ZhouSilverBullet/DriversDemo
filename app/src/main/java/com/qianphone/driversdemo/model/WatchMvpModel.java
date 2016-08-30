package com.qianphone.driversdemo.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.qianphone.driversdemo.sql.MyOpenHelper;
import com.qianphone.driversdemo.utils.DriversApplication;
import com.qianphone.driversdemo.utils.HttpUtils;

/**
 * Created by 周周 on 2016/8/30.
 */
public class WatchMvpModel implements MvpModel{


    public void modelData(RecommendMvpModel.ModelForHttpData modelForHttpData, String path){
        MyOpenHelper myOpenHelper = new MyOpenHelper(DriversApplication.getContext());
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
        Cursor query = db.query("info", null, null, null, null, null, null);
        while (query.moveToNext()) {
            String article_id = query.getString(1);
            String json = query.getString(2);
        }

        HttpUtils.httpGet(modelForHttpData,path);
    }


}
