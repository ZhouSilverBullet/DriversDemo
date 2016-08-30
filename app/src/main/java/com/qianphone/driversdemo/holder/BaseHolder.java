package com.qianphone.driversdemo.holder;

import android.view.View;

/**
 * Created by 周周 on 2016/8/25.
 */
public abstract class BaseHolder<T> {
    public View mRootView;
    public T data;

    public BaseHolder(){
        mRootView = initView();
        mRootView.setTag(this);
    }

    public void setData(T data){
        this.data =data;
        refreshData(data);
    }

    public T getData(){
        return data;
    }

    public View getRootView(){
        return mRootView;
    }
    public abstract View initView();

    public abstract void refreshData(T t);
}
