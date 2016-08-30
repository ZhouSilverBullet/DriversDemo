package com.qianphone.driversdemo.utils;

/**
 * Created by 周周 on 2016/8/25.
 */
public interface ConstantValue {
    String SERVER_URL="http://dt.kkeji.com/api/1/";
    String RECOMMEND_URL=SERVER_URL +"contents?min_pub_time=0&article_type=-1&sign=-477263451&min_show_time=0&xaid=7b920b9704f24c3b&udid=5186261861683913428";
    String MOREPAGE = SERVER_URL + "contents?article_type=%d&sign=-477263451&xaid=7b920b9704f24c3b&udid=5186261861683913428&max_show_time=%d";
    String DETAIL_URL=SERVER_URL+"contents/details?sign=-477263451&nids=%d&xaid=7b920b9704f24c3b&udid=5186261861683913428";
    String STATE="state";
    String IS_CHECK ="ischeck";
}
