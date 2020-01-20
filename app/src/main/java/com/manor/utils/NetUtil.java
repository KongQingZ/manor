package com.manor.utils;

import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;


/*
* 此工具类是网络请求工具类，其中包含get和post请求，一律返回的是Call，用于返回值的数据处理
* */
public class NetUtil {

    private OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * 异步Get
     * @param url 请求的网址，带有参数
     * @return Call，用于进行返回结果的处理
     */
    Call netAsynGet(String url, Map<String,String> header){

        final Request.Builder builder = new Request.Builder();

        //假如header不为空，那么说明需要header
        if (!header.isEmpty()){
            for (String token : header.keySet()) {
                builder.header(token,header.get(token));
            }
        }

        final Request request = builder
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        return okHttpClient.newCall(request);
//这里是返回值的处理示例
/*        //返回结果
        call.enqueue(new Callback() {
            //失败之后的处理
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }
            //成功之后的处理
            public void onResponse(Call call, Response response) throws IOException {
                //response.body().string()得到返回结果
                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });*/
    }

    /**
     * 异步Post提交
     * @param url 网址
     * @param values 请求值
     * @param header 请求头(token等)
     * @return Call，用来处理返回值
     */
    Call netAsynPost(String url,Map<String,String> values,Map<String,String> header){

        final FormBody.Builder formBuilder = new FormBody.Builder();

        if (!values.isEmpty()){
            for (String string : values.keySet()) {
                formBuilder.add(string,values.get(string));
            }
        }

        final RequestBody requestBody = formBuilder
                .build();

        final Request.Builder builder = new Request.Builder();

        if (!header.isEmpty()){
            for (String token : header.keySet()) {
                builder.header(token,header.get(token));
            }
        }

        final Request request = builder
                .url(url)
                .post(requestBody)
                .build();

        return okHttpClient.newCall(request);
//这里是返回值的处理示例
/*        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("okhttp", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //response.body().string()得到返回结果
                Log.d("okhttp", "onResponse: " + response.body().string());
            }
        });*/
    }

}
