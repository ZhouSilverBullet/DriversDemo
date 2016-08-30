package com.qianphone.driversdemo.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qianphone.driversdemo.R;
import com.qianphone.driversdemo.presenter.BasePresenter;
import com.qianphone.driversdemo.view.MvpView;
import com.qianphone.driversdemo.view.activity.DetailActivity;

/**
 *
 * Created by 周周 on 2016/8/25.
 */
public abstract class BaseFragment<V extends MvpView,T extends BasePresenter<V>> extends Fragment implements AbsListView.OnScrollListener {
    public T basePresenter;
    public ListView mTabListView;

    public boolean isMore =true;
    public boolean isLonding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresenter= getPresenter();
        basePresenter.attach((V)this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_list_fragment,container,false);
        mTabListView = (ListView) view.findViewById(R.id.lv_tab_list_view);
        mTabListView.setOnScrollListener(this);
        baseView();

        return view;
    }

    /**
     * 具体要的数据
     */
    protected abstract void baseView();

    @Override
    public void onDestroy() {
        super.onDestroy();
        basePresenter.detach();
    }

    public abstract T getPresenter() ;


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE&&isLonding) {
            isLonding =false;
            isMore =false;
            loadMore();
        }
    }

    protected abstract void loadMore();

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //firstVisible
            if(isMore&&firstVisibleItem + visibleItemCount == totalItemCount){
                View childAt = view.getChildAt(visibleItemCount - 1);
                if(childAt!=null&&childAt.getBottom() == view.getHeight()){
                    isLonding = true;
                }
            }
    }

    public void isLoadedMore() {
        isMore =true;
    }



}
