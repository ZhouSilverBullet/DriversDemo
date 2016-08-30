package com.qianphone.driversdemo.view;

import com.qianphone.driversdemo.bean.RecommendBean;

/**
 * Created by 周周 on 2016/8/30.
 */
public interface WatchMvpView extends MvpView{
    void showView(RecommendBean recommendBean);
}
