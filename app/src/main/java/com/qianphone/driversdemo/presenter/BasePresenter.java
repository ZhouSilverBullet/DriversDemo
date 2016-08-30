package com.qianphone.driversdemo.presenter;

import com.qianphone.driversdemo.view.MvpView;

import java.lang.ref.WeakReference;

/**
 * Created by 周周 on 2016/8/25.
 */
public abstract class BasePresenter<V extends MvpView> {

    private WeakReference<V> mVWeakReference;

    public void attach(V v){
        mVWeakReference = new WeakReference<V>(v);
    }

    public void detach(){
        if (mVWeakReference != null) {
            mVWeakReference.clear();
            mVWeakReference=null;
        }
    }

    public V getView(){
        if (mVWeakReference != null) {
           return mVWeakReference.get();
        }
        return null;
    }
    public abstract void presenterLoad(String path);
}
