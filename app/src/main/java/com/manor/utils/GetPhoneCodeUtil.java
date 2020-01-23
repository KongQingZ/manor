package com.manor.utils;

import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.manor.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GetPhoneCodeUtil {

    public static String getKey(String phone) {

        Map<String, String> values = new HashMap();
        Map<String, String> headers = new HashMap();
        values.put("phone", phone);


        Call call = NetUtil.netPost("https://api.habitevolve.com" + "/api/v1/code", values, headers);

        String key = "";

        try {
            Response response = call.execute();

            String jsonString = response.body().string();

            JSONObject object = JSON.parseObject(jsonString);

            JSONObject data = object.getJSONObject("data");

            key = data.getString("key");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return key;
    }
}