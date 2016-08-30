package com.qianphone.driversdemo.model;

import com.qianphone.driversdemo.utils.HttpUtils;

/**
 * Created by 周周 on 2016/8/25.
 */
public class RecommendMvpModel implements MvpModel{
    public void modelData(ModelForHttpData modelForHttpData,String path){
        HttpUtils.httpGet(modelForHttpData,path);
    }
    public interface ModelForHttpData{
        void modelForHttpData(byte[] bytes,String path);
    }
}
