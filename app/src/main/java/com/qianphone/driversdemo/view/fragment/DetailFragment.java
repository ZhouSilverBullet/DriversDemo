package com.qianphone.driversdemo.view.fragment;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.qianphone.driversdemo.R;
import com.qianphone.driversdemo.bean.DetailBean;
import com.qianphone.driversdemo.presenter.DetailPresenter;
import com.qianphone.driversdemo.sql.MyOpenHelper;
import com.qianphone.driversdemo.utils.ConstantValue;
import com.qianphone.driversdemo.utils.SpUtils;
import com.qianphone.driversdemo.view.DetailMvpView;
import com.qianphone.driversdemo.view.activity.MainActivity;

/**
 * Created by 周周 on 2016/8/26.
 */
public class DetailFragment extends BaseFragment<DetailMvpView, DetailPresenter> implements View.OnClickListener, DetailMvpView {

    private WebView mWebView;
    private TextView mTvRecommend;
    private CheckBox mCheckBox;
    private String mJson;
    private int mNds;
    boolean isExist;  //数据库是否存在
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        mWebView = (WebView) view.findViewById(R.id.detail_web);
        initView(view);

        Bundle arguments = getArguments();
        mNds = arguments.getInt("nds", -1);

        basePresenter.presenterLoad(String.format(ConstantValue.DETAIL_URL, mNds));


        Cursor query = new MyOpenHelper(getContext()).getWritableDatabase().query("info", new String[]{"json"}, "article_id=?", new String[]{mNds + ""}, null, null, null);
        mCheckBox.setChecked(false);
        while (query.moveToNext()) {
            Log.e("自定义标签", "类名==DetailFragment" + "方法名==onCreateView=====:" + query.getString(0));
            if(!TextUtils.isEmpty(query.getString(0))){
                mCheckBox.setChecked(true);
                isExist = true;
            }
        }

        query.close();
        return view;
    }

    private void initView(View view) {
        //Cursor query = getActivity().getContentResolver().query(Uri.parse("content://xxx.qianfeng.my_content/query"), null, null, null, null);

        mTvRecommend = (TextView) view.findViewById(R.id.tv_recommend);
        mCheckBox = (CheckBox) view.findViewById(R.id.cb_watch);
        mCheckBox.setChecked(SpUtils.getBoolean(ConstantValue.IS_CHECK, false));
        mTvRecommend.setOnClickListener(this);
    }

    @Override
    protected void baseView() {

    }

    @Override
    public DetailPresenter getPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void loadMore() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_recommend:
                //TODO 缺fragment
                ChatFragment chatFragment = new ChatFragment();
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_exit, R.anim.fragment_enter, R.anim.fragment_exit).replace(R.id.fl_container, chatFragment).addToBackStack(chatFragment.getClass().getSimpleName()).commit();
                break;
            case R.id.tv_back:
//                Intent intent = new Intent();
//                Log.e("自定义标签", "类名==DetailFragment" + "方法名==onClick=====:" + mCheckBox.isChecked());
//                intent.putExtra("isChecked", mCheckBox.isChecked());
//                intent.putExtra("json", mJson);
//                getActivity().setResult(Activity.RESULT_OK, intent);
                getActivity().finish();
               // SpUtils.setBoolean(ConstantValue.IS_CHECK, mCheckBox.isChecked());

                break;
            case R.id.cb_watch:
                Log.e("自定义标签", "类名==DetailFragment" + "方法名==onClick=====:" + "");
                break;
        }
    }

    /**
     * 在停止的时候存数据
     */
    @Override
    public void onStop() {
//        Intent intent = new Intent();
        Log.e("自定义标签", "类名==DetailFragment" + "方法名==onClick=====:" + mCheckBox.isChecked());
//        intent.putExtra("isChecked", mCheckBox.isChecked());
//        intent.putExtra("json", mJson);
//        getActivity().setResult(Activity.RESULT_OK, intent);

        if(mCheckBox.isChecked()&&!isExist){

            ContentValues values = new ContentValues();
            values.put("article_id",mNds);
            values.put("json",mJson);
            long insert = new MyOpenHelper(getContext()).getWritableDatabase().insert("info", null, values);
    //        while (query.moveToNext()) {
    //            Log.e("自定义标签", "类名==DetailFragment" + "方法名==onCreateView=====:" + query.getString(0));
    //        }
    //        getActivity().finish();
    //        SpUtils.setBoolean(ConstantValue.IS_CHECK, mCheckBox.isChecked());
            Log.e("自定义标签", "类名==DetailFragment" + "方法名==onStop=====:" + insert);
        }else {
            int delete = new MyOpenHelper(getContext()).getWritableDatabase().delete("info", "article_id=?", new String[]{mNds + ""});
            Log.e("自定义标签", "类名==DetailFragment" + "方法名==onStop=====:delete=" + delete);
        }
        super.onStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();



    }

    @Override
    public void showView(DetailBean detailBean) {
        mJson = new Gson().toJson(detailBean);
        mWebView.loadData(detailBean.getData().getNews().get(0).getArticle_content() + "<br/><br/><br/><br/>", "text/html;charset=utf-8", null);
    }
}
