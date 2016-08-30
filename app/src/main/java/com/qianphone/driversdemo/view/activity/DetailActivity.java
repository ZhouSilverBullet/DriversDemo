package com.qianphone.driversdemo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.qianphone.driversdemo.R;
import com.qianphone.driversdemo.bean.DetailBean;
import com.qianphone.driversdemo.presenter.BasePresenter;
import com.qianphone.driversdemo.presenter.DetailPresenter;
import com.qianphone.driversdemo.utils.ConstantValue;
import com.qianphone.driversdemo.view.DetailMvpView;
import com.qianphone.driversdemo.view.fragment.DetailFragment;

/**
 * Created by 周周 on 2016/8/25.
 *
 */
public class DetailActivity extends AppCompatActivity{

    private WebView mWebView;
    private TextView mTvRecommend;
    private DetailFragment mDetailFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int nds = intent.getIntExtra("nds", 0);

        Log.e("自定义标签", "类名==DetailActivity" + "方法名==onCreate=====:" + nds);
//        DetailPresenter detailPresenter = new DetailPresenter();
//        basePresenter.presenterLoad(String.format(ConstantValue.DETAIL_URL,nds));
        mDetailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("nds",nds);
        mDetailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,mDetailFragment,mDetailFragment.getClass().getSimpleName()).commit();

    }

//    @Override
//    public BasePresenter getPresenter() {
//        return new DetailPresenter();
//    }
//
//    @Override
//    public void showView(DetailBean detailBean) {
//        mWebView.loadData(detailBean.getData().getNews().get(0).getArticle_content(),"text/html;charset=utf-8", null);
//    }

    public void onClick(View view) {
        Fragment fragmentByTag = getSupportFragmentManager().findFragmentByTag(mDetailFragment.getClass().getSimpleName());
        if(fragmentByTag!=null&&fragmentByTag instanceof DetailFragment){
            ((DetailFragment) fragmentByTag).onClick(view);
        }
    }
}
