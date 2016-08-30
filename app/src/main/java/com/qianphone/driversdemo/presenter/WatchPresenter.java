package com.qianphone.driversdemo.presenter;

import com.qianphone.driversdemo.model.RecommendMvpModel;
import com.qianphone.driversdemo.model.WatchMvpModel;
import com.qianphone.driversdemo.view.WatchMvpView;

/**
 * Created by 周周 on 2016/8/30.
 */
public class WatchPresenter extends BasePresenter<WatchMvpView>{
    private WatchMvpModel mMvpModel;

    public WatchPresenter() {
        mMvpModel = new WatchMvpModel();
    }

    @Override
    public void presenterLoad(String path) {
      mMvpModel.modelData(new RecommendMvpModel.ModelForHttpData() {
          @Override
          public void modelForHttpData(byte[] bytes, String path) {

          }
      },path);
    }
}
