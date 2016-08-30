package com.qianphone.driversdemo.view.fragment;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.qianphone.driversdemo.adapter.RecommendAdapter;
import com.qianphone.driversdemo.bean.RecommendBean;
import com.qianphone.driversdemo.presenter.RecommendPresenter;
import com.qianphone.driversdemo.utils.ConstantValue;
import com.qianphone.driversdemo.view.RecommendMvpView;
import com.qianphone.driversdemo.view.activity.DetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周周 on 2016/8/25.
 */
public class RecommendFragment extends BaseFragment<RecommendMvpView, RecommendPresenter> implements RecommendMvpView, AdapterView.OnItemClickListener {

    private RecommendAdapter mAdapter;
    private List<RecommendBean.DataBean.NewsBean> mNewsBeanList;
    private int mNextShowTime;
    private int mArticle_id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresenter.presenterLoad(ConstantValue.RECOMMEND_URL);
    }

    @Override
    protected void baseView() {
        mNewsBeanList = new ArrayList<>();

        mAdapter = new RecommendAdapter(mNewsBeanList);
        mTabListView.setAdapter(mAdapter);
        mTabListView.setOnItemClickListener(this);
    }

    @Override
    public RecommendPresenter getPresenter() {
        return new RecommendPresenter();
    }

    @Override
    protected void loadMore() {
        basePresenter.presenterLoad(String.format(ConstantValue.MOREPAGE, -1, mNextShowTime));
    }

    @Override
    public void showView(RecommendBean recommendBean) {
        isLoadedMore();
        mNextShowTime = recommendBean.getData().getNext_show_time();
        List<RecommendBean.DataBean.NewsBean> news = recommendBean.getData().getNews();

//        Log.e("自定义标签", "类名==RecommendFragment" + "方法名==showView=====:" + news.size());
//        Log.e("自定义标签", "类名==RecommendFragment" + "方法名==showView=====:" + news.get(0).getTitle());
//        Log.e("自定义标签", "类名==RecommendFragment" + "方法名==showView=====:" + news.get(1).getTitle());
//        Log.e("自定义标签", "类名==RecommendFragment" + "方法名==showView=====:" + news.get(2).getTitle());
//        Log.e("自定义标签", "类名==RecommendFragment" + "方法名==showView=====:" + news.get(3).getTitle());
        mNewsBeanList.addAll(news);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RecommendBean.DataBean.NewsBean newsBean = mNewsBeanList.get(position);
        mArticle_id = newsBean.getArticle_id();
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("nds", mArticle_id);
        startActivityForResult(intent, 100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
                Log.e("自定义标签", "类名==RecommendFragment" + "方法名==onActivityResult=====:" + "");
        if (requestCode == 100 && data != null) {
            boolean isChecked = data.getBooleanExtra("isChecked", false);
            String json = data.getStringExtra("json");
            if (isChecked) {
                ContentValues values = new ContentValues();
                values.put("article_id", mArticle_id);
                values.put("json", json);
                Uri insert = getActivity().getContentResolver().insert(Uri.parse("content://xxx.qianfeng.my_content/insert"), values);
                Log.e("自定义标签", "类名==RecommendFragment" + "方法名==onActivityResult=====:" + insert);
            }else {
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
