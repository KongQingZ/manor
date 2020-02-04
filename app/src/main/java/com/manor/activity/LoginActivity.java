package com.manor.activity;
/**
 * 界面实现登录功能，主要是账户密码登录
 */

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.manor.R;
import com.manor.utils.NetUtil;
import com.manor.utils.SPUtil;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    public Button btnLogin;  //登录主界面
    public EditText Phone;    //登录手机号码
    public EditText PassWord;  //登录密码
    public Button RePassword;   //找回密码
    public TextView PhoneLogin; //手机验证码
    public TextView NewPeoper;   //注册新用户

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*下面两局是解决android不允许主线程访问网络请求的*/
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());

        RePassword = (Button) findViewById(R.id.FindPassword);//跳转到重置页面
        btnLogin = (Button) findViewById(R.id.BtLogin);
        Phone = (EditText) findViewById(R.id.Phone);   //手机号
        PassWord = (EditText) findViewById(R.id.PassWord);   //登录密码
        PhoneLogin = (TextView) findViewById(R.id.PhoneLogin);   //手机验证码登录
        NewPeoper = (TextView) findViewById(R.id.NewPeoper);   //注册新用户

        /*--------------- 点击事件 ---------------*/
        RePassword.setOnClickListener(ResetPassword);
        btnLogin.setOnClickListener(Login);  //登录主界面

    }

    /*--------------- 找回密码/重置界面，点击事件 ---------------*/
    View.OnClickListener ResetPassword = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent login = new Intent(LoginActivity.this, ResetPassword.class);
            startActivity(login);
            finish();
        }
    };

    /*--------------- 登录按钮  点击事件 ---------------*/
    View.OnClickListener Login = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String mphone;
            String mpassword;
            mphone=  Phone.getText().toString().trim();
            mpassword =PassWord.getText().toString().trim();
            Map<String, String> values = new HashMap();     //存放具体的值
            Map<String, String> headers = new HashMap();     //存放token
            values.put("phone",mphone);
            values.put("password",mpassword);
            Call call = NetUtil.netPost("https://api.habitevolve.com" + "/api/v1/authorizations", values, headers);

            try {
                Response  response = call.execute();
                String jsonstring = response.body().string();
                Log.i("返回值", jsonstring);
                JSONObject object = JSON.parseObject(jsonstring);   // jsonstring  穿回来的json全部的值
                JSONObject data =    object.getJSONObject("data");    //获取JSON对象；
                Float user_id = data.getFloat("user_id");
                String username = data.getString("username");
                String avatar = data.getString("avatar");
                Integer money = data.getInteger("money");
                String token = data.getString("token");
                Log.i(com.manor.utils.TAG.INFO, "输出: token："+token);
                SPUtil.setParam(LoginActivity.this,"token",token);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };


}
