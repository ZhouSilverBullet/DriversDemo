package com.qianphone.driversdemo.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qianphone.driversdemo.holder.BaseHolder;

import java.util.List;

/**
 * Created by 周周 on 2016/8/25.
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter{
    public List<T> mList;

    public MyBaseAdapter(List<T> list){
        mList =list;
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder baseHolder;
        if(convertView == null){
            baseHolder = getHolder();
        }else {
            baseHolder = (BaseHolder) convertView.getTag();
//            Log.e("自定义标签", "类名==MyBaseAdapter" + "方法名==getView=====:convertView.getTag()==" + convertView.getTag());
        }
//        if(getItem(position)!=null){
            baseHolder.setData(getItem(position));
//        Log.e("自定义标签", "类名==MyBaseAdapter" + "方法名==getView=====:" + mList.get(position));
//        }

        return baseHolder.getRootView();
    }

    public abstract BaseHolder getHolder();
}
