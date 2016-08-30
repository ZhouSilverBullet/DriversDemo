package com.qianphone.driversdemo.view.fragment;

import com.qianphone.driversdemo.presenter.WatchPresenter;
import com.qianphone.driversdemo.view.WatchMvpView;

/**
 * Created by 周周 on 2016/8/30.
 */
public class WatchFragment extends BaseFragment<WatchMvpView,WatchPresenter>{

    @Override
    protected void baseView() {

    }

    @Override
    public WatchPresenter getPresenter() {
        return null;
    }

    @Override
    protected void loadMore() {

    }
}
