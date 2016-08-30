package com.qianphone.driversdemo.utils;

import android.os.Handler;
import android.os.Looper;

import com.qianphone.driversdemo.model.RecommendMvpModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 周周 on 2016/8/25.
 */
public class HttpUtils {
    public static OkHttpClient sOkHttpClient = new OkHttpClient();
    public static Handler sHandler = new Handler(Looper.getMainLooper());

    public static void httpGet(final RecommendMvpModel.ModelForHttpData modelForHttpData){
        Request request = new Request.Builder().get().url("").build();
        sOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final byte[] bs = response.body().bytes();
                sHandler.post(new Runnable() {
                    @Override
                    public void run() {
                         modelForHttpData.modelForHttpData(bs,"");

                    }
                });
            }
        });
    }
    public static void httpGet(final RecommendMvpModel.ModelForHttpData modelForHttpData, final String path){
        Request request = new Request.Builder().get().url(path).build();
        sOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final byte[] bs = response.body().bytes();
                sHandler.post(new Runnable() {
                    @Override
                    public void run() {
                         modelForHttpData.modelForHttpData(bs,path);

                    }
                });
            }
        });
    }
}
