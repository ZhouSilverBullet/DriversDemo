package com.qianphone.driversdemo.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 周周 on 2016/8/26.
 */
public class MyOpenHelper extends SQLiteOpenHelper {
    public static final String NAME= "test.db";
    public static final int VERSION =1;

    public MyOpenHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table info (_id integer primary key autoincrement,article_id integer,json text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
