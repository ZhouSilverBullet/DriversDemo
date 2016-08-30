package com.qianphone.driversdemo.presenter;

import com.google.gson.Gson;
import com.qianphone.driversdemo.bean.DetailBean;
import com.qianphone.driversdemo.bean.RecommendBean;
import com.qianphone.driversdemo.model.RecommendMvpModel;
import com.qianphone.driversdemo.view.DetailMvpView;
import com.qianphone.driversdemo.view.RecommendMvpView;

/**
 * Created by 周周 on 2016/8/25.
 */
public class DetailPresenter extends BasePresenter<DetailMvpView>{
    private RecommendMvpModel mMvpModel;

    public DetailPresenter() {
        mMvpModel = new RecommendMvpModel();
    }

    public void presenterLoad(String path){
        mMvpModel.modelData(new RecommendMvpModel.ModelForHttpData() {
            @Override
            public void modelForHttpData(byte[] bytes, String path) {

                DetailBean detailBean = new Gson().fromJson(new String(bytes), DetailBean.class);
                getView().showView(detailBean);
            }
        },path);
    }
}
