package com.qianphone.driversdemo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;

/**
 * Created by 周周 on 2016/8/26.
 */
public class MyLruCache extends LruCache<String,Bitmap>{

    public static MyLruCache sMyLruCache = new MyLruCache((int) (Runtime.getRuntime().maxMemory()/1024/8));

    public static MyLruCache getInstance(){
        return sMyLruCache;
    }
    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *                the maximum number of entries in the cache. For all other caches,
     *                this is the maximum sum of the sizes of the entries in this cache.
     */
    public MyLruCache(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getHeight()*value.getRowBytes()/1024;
    }
}
