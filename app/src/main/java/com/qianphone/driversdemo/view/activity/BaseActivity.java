package com.qianphone.driversdemo.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.qianphone.driversdemo.presenter.BasePresenter;
import com.qianphone.driversdemo.view.MvpView;

/**
 * Created by 周周 on 2016/8/25.
 */
public abstract class BaseActivity<V extends MvpView,T extends BasePresenter<V>> extends AppCompatActivity{
    public T basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        basePresenter = getPresenter();
        basePresenter.attach((V)this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (basePresenter!=null) {
        basePresenter.detach();

        }
    }

    public abstract T getPresenter() ;
}
