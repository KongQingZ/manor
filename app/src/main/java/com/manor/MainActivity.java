package com.manor;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;

import com.manor.activity.LoginActivity;

import androidx.appcompat.app.AppCompatActivity;

/*总控台，用于管理界面跳转*/
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*下面两局是解决android不允许主线程访问网络请求的*/
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
        //跳转登录界面
        Intent login = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(login);
        finish();
    }
}