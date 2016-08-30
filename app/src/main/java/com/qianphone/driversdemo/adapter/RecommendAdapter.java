package com.qianphone.driversdemo.adapter;

import com.qianphone.driversdemo.bean.RecommendBean;
import com.qianphone.driversdemo.holder.BaseHolder;
import com.qianphone.driversdemo.holder.RecommendHolder;

import java.util.List;

/**
 *
 * Created by 周周 on 2016/8/25.
 */
public class RecommendAdapter extends MyBaseAdapter<RecommendBean.DataBean.NewsBean>{
    public RecommendAdapter(List<RecommendBean.DataBean.NewsBean> list) {
        super(list);
    }

    @Override
    public BaseHolder getHolder() {
        return new RecommendHolder();
    }
}
