package com.qianphone.driversdemo.presenter;

import com.google.gson.Gson;
import com.qianphone.driversdemo.bean.DetailBean;
import com.qianphone.driversdemo.model.ChatMvpModel;
import com.qianphone.driversdemo.model.RecommendMvpModel;
import com.qianphone.driversdemo.view.ChatMvpView;
import com.qianphone.driversdemo.view.DetailMvpView;

/**
 * Created by 周周 on 2016/8/25.
 */
public class ChatPresenter extends BasePresenter<ChatMvpView>{
    private ChatMvpModel mMvpModel;

    public ChatPresenter() {
        mMvpModel = new ChatMvpModel();
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
