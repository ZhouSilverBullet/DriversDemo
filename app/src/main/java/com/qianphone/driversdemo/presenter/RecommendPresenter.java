package com.qianphone.driversdemo.presenter;

import com.google.gson.Gson;
import com.qianphone.driversdemo.bean.RecommendBean;
import com.qianphone.driversdemo.model.RecommendMvpModel;
import com.qianphone.driversdemo.view.RecommendMvpView;

/**
 * Created by 周周 on 2016/8/25.
 */
public class RecommendPresenter extends BasePresenter<RecommendMvpView>{
    private RecommendMvpModel mMvpModel;

    public RecommendPresenter() {
        mMvpModel = new RecommendMvpModel();
    }

    public void presenterLoad(String path){
        mMvpModel.modelData(new RecommendMvpModel.ModelForHttpData() {
            @Override
            public void modelForHttpData(byte[] bytes, String path) {
                RecommendBean recommendBean = new Gson().fromJson(new String(bytes), RecommendBean.class);
                getView().showView(recommendBean);
            }
        },path);
    }
}
