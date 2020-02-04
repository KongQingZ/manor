package com.manor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.manor.R;
import com.manor.utils.GetPhoneCodeUtil;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPassword extends AppCompatActivity {
    //    public

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        //测试存储值
        //        Log.i("输出：", SPUtil.getParam(ResetPassword.this,"token","").toString());
        String st =  GetPhoneCodeUtil.getKey("17861313485");   //获取验证码的K
        Log.i("输出验证码K", st);
    }

    //返回登录界面
    public void btn(View view){
        Intent login = new Intent(ResetPassword.this, LoginActivity.class);
        startActivity(login);
        finish();
    }
}
