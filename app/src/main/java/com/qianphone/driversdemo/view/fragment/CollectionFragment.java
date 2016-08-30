package com.qianphone.driversdemo.view.fragment;

import com.qianphone.driversdemo.presenter.DetailPresenter;
import com.qianphone.driversdemo.view.DetailMvpView;

/**
 * 收藏好的
 * 
 * Created by 周周 on 2016/8/26.
 */
public class CollectionFragment extends BaseFragment<DetailMvpView,DetailPresenter>{
    @Override
    protected void baseView() {

    }

    @Override
    public DetailPresenter getPresenter() {
        return null;
    }

    @Override
    protected void loadMore() {

    }
}
