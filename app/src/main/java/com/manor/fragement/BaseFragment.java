package com.manor.fragement;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 作用  基类Fragment
 * 子类继承这个Fragment实现不同的功能
 * 首页：HomeFragment
 * 任务：TaskFragment
 * 社区：CommunityFragment
 * 我的：UserFragment
 * 等等都要基类
 */
public abstract class BaseFragment extends Fragment {
    protected Context mContext;

    /**
     * 当该类被系统创建的时候被回调
     * 获取上下文，初始化控件
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    /*--------------- onCreateView是创建该fragment对应的视图，其中需要创建自己的视图并返回给调用者； ---------------*/
    /*--------------- super.onCreateView无所谓是否有调用，因为super.onCreateView直接返回null。 ---------------*/
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initview();
    }

    /**
     * 抽象类，由孩子实现，实现不同的效果
     */
    protected  abstract View initview();

    /**
     * 当Activity被创建的时候回调这个方法
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }
    /**
     * 当子类需要联网请求时，可以重写改方法，在该方法中联网请求
     */
    public void initDate() {
        
    }
}

