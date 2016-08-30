package com.qianphone.driversdemo.model;

import com.qianphone.driversdemo.utils.HttpUtils;

/**
 * Created by 周周 on 2016/8/25.
 */
public class ChatMvpModel implements MvpModel{
    public void modelData(RecommendMvpModel.ModelForHttpData modelForHttpData, String path){
        HttpUtils.httpGet(modelForHttpData,path);
    }
}
