package com.qianphone.driversdemo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.qianphone.driversdemo.model.RecommendMvpModel;

/**
 * Created by 周周 on 2016/8/26.
 */
public class MyBitmapCallBack implements RecommendMvpModel.ModelForHttpData{
    String paths;
    ImageView mImageView;
    public MyBitmapCallBack(ImageView imageView, String paths) {
        mImageView = imageView;
        this.paths = paths;
    }

    @Override
    public void modelForHttpData(byte[] bytes, String path) {

        if(paths.equals(path)&&bytes!=null){
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            mImageView.setImageBitmap(bitmap);
            MyLruCache.getInstance().put(path, bitmap);
        }
    }
}
