package com.qianphone.driversdemo.view.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qianphone.driversdemo.bean.DetailBean;
import com.qianphone.driversdemo.model.ChatMvpModel;
import com.qianphone.driversdemo.presenter.ChatPresenter;
import com.qianphone.driversdemo.view.ChatMvpView;

/**
 * Created by 周周 on 2016/8/26.
 */
public class ChatFragment extends BaseFragment<ChatMvpView,ChatPresenter> implements ChatMvpView{
    @Override
    protected void baseView() {

        mTabListView.setAdapter(new MyAdapter());
//        basePresenter.presenterLoad("");
    }

    @Override
    public ChatPresenter getPresenter() {
        return new ChatPresenter();
    }

    @Override
    protected void loadMore() {

    }

    @Override
    public void showView(DetailBean detailBean) {

    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(getActivity());
            textView.setText("这是手动生成的"+parent);
            textView.setTextSize(35);
            return textView;
        }
    }
}
