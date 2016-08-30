package com.qianphone.driversdemo.holder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qianphone.driversdemo.R;
import com.qianphone.driversdemo.bean.RecommendBean;
import com.qianphone.driversdemo.model.RecommendMvpModel;
import com.qianphone.driversdemo.utils.DriversApplication;
import com.qianphone.driversdemo.utils.HttpUtils;
import com.qianphone.driversdemo.utils.MyBitmapCallBack;
import com.qianphone.driversdemo.utils.MyLruCache;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 周周 on 2016/8/25.
 */
public class RecommendHolder extends BaseHolder<RecommendBean.DataBean.NewsBean> {

    private ImageView mIvImg0;
    private ImageView mIvImg1;
    private ImageView mIvImg2;
    private ImageView mIvImg3;
    private TextView mTvSource0;
    private TextView mTvSource1;
    private LinearLayout mLayoutX;
    private LinearLayout mLayoutY;
    private TextView mTvTitle0;
    private TextView mTvTitle1;

    @Override
    public View initView() {
        View view = View.inflate(DriversApplication.getContext(), R.layout.recommend_item_0, null);
        mIvImg0 = (ImageView) view.findViewById(R.id.iv_image_0);
        mIvImg1 = (ImageView) view.findViewById(R.id.iv_image_1);
        mIvImg2 = (ImageView) view.findViewById(R.id.iv_image_2);
        mIvImg3 = (ImageView) view.findViewById(R.id.iv_image_3);

        mTvTitle0 = (TextView) view.findViewById(R.id.tv_title0);
        mTvTitle1 = (TextView) view.findViewById(R.id.tv_title);

        mTvSource0 = (TextView) view.findViewById(R.id.tv_source0);
        mTvSource1 = (TextView) view.findViewById(R.id.tv_source);

        mLayoutX = (LinearLayout) view.findViewById(R.id.ll_item_x);
        mLayoutY = (LinearLayout) view.findViewById(R.id.ll_item_y);

        return view;
    }

    @Override
    public void refreshData(RecommendBean.DataBean.NewsBean newsBean) {
        List<String> imgs = newsBean.getImgs();
        Log.e("自定义标签", "类名==RecommendHolder" + "方法名==refreshData=====:" + newsBean.getTitle());
        if (imgs.size() >= 2) {
            mLayoutX.setVisibility(View.GONE);
            mLayoutY.setVisibility(View.VISIBLE);
            mTvTitle1.setText(newsBean.getTitle());
            mIvImg1.setImageBitmap(null);
            mIvImg2.setImageBitmap(null);
            mIvImg3.setImageBitmap(null);
            Bitmap bitmap = MyLruCache.getInstance().get(imgs.get(0));
            Bitmap bitmap1 = MyLruCache.getInstance().get(imgs.get(1));
            Bitmap bitmap2 = MyLruCache.getInstance().get(imgs.get(2));
            setBitmapImage(bitmap,mIvImg1,imgs.get(0));
            setBitmapImage(bitmap1,mIvImg2,imgs.get(1));
            setBitmapImage(bitmap2,mIvImg3,imgs.get(2));



//            Picasso.with(DriversApplication.getContext()).load(imgs.get(0)).into(mIvImg1);
//            Picasso.with(DriversApplication.getContext()).load(imgs.get(1)).into(mIvImg2);
//            Picasso.with(DriversApplication.getContext()).load(imgs.get(2)).into(mIvImg3);
            mTvSource1.setText(newsBean.getSource());
        } else {
            mLayoutX.setVisibility(View.VISIBLE);
            mLayoutY.setVisibility(View.GONE);
            mTvTitle0.setText(newsBean.getTitle());
            if (imgs.size() != 0) {
                mIvImg0.setImageBitmap(null);
                HttpUtils.httpGet(new MyBitmapCallBack(mIvImg0, imgs.get(0)), imgs.get(0));
//              Picasso.with(DriversApplication.getContext()).load(imgs.get(0)).into(mIvImg0);
            } else {
//                Picasso.with(DriversApplication.getContext()).load(R.mipmap.ic_launcher).into(mIvImg0);
                mIvImg0.setVisibility(View.GONE);
            }
            mTvSource0.setText(newsBean.getSource());
        }

    }

    public void setBitmapImage(Bitmap bitmap,ImageView imageView,String path){
        if (bitmap == null) {
            HttpUtils.httpGet(new MyBitmapCallBack(imageView, path), path);
        }else {
            imageView.setImageBitmap(bitmap);
        }
    }


}
