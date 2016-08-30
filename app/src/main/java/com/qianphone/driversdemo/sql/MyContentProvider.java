package com.qianphone.driversdemo.sql;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by 周周 on 2016/8/26.
 */
public class MyContentProvider extends ContentProvider {
    //xxx.qianfeng.my_content
    private MyOpenHelper mMyOpenHelper;

    public static final String AUTHORITY ="xxx.qianfeng.my_content";
    public static final String QUERY="query";
    public static final String INSERT="insert";
    public static final String UPDATE="update";
    public static final String DELETE="delete";

    public static final int QUERY_SUCCESS =0;
    public static final int INSERT_SUCCESS =1;
    public static final int DELETE_SUCCESS =2;


    private static UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(AUTHORITY,QUERY,QUERY_SUCCESS);
        sUriMatcher.addURI(AUTHORITY,INSERT,INSERT_SUCCESS);
        sUriMatcher.addURI(AUTHORITY,DELETE,DELETE_SUCCESS);
    }

    @Override
    public boolean onCreate() {
        mMyOpenHelper = new MyOpenHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (sUriMatcher.match(uri) ==INSERT_SUCCESS) {
            SQLiteDatabase db = mMyOpenHelper.getWritableDatabase();
            long insert = db.insert("info", null, values);
            return ContentUris.withAppendedId(uri,insert);
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (sUriMatcher.match(uri) == DELETE_SUCCESS) {
            SQLiteDatabase db = mMyOpenHelper.getWritableDatabase();
            int delete = db.delete("info", selection, selectionArgs);
            return delete;
        }

        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
