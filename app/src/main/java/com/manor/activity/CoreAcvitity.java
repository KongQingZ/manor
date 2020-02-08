package com.manor.activity;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.manor.R;
import com.manor.fragement.AssociationFragment;
import com.manor.fragement.BaseFragment;
import com.manor.fragement.HomeFragment;
import com.manor.fragement.ManorFragment;
import com.manor.fragement.TaskFragment;
import com.manor.fragement.UserFragment;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class CoreAcvitity extends FragmentActivity {
    private RadioGroup rg_main;
    //装多个Fragment
    private ArrayList<BaseFragment> fragments;
    private int position = 0;
    //缓存的Fragment或者说是上次显示的Fragment
    private Fragment tempFragemnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_acvitity);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);

        //初始化Fragment
        initFragment();
        initListener();
    }

    private void initListener() {
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:  //主页
                        position = 0;
                        break;
                    case R.id.rb_task:  //任务
                        position = 1;
                        break;
                    case R.id.rb_manor://庄园
                        position = 2;
                        break;
                    case R.id.rb_association: //社区
                        position = 3;
                        break;
                    case R.id.rb_user:  //我的
                        position = 4;
                        break;
                    default:
                        position = 0;
                        break;
                }
                //根据位置取不同的Fragment
                BaseFragment baseFragment = getFragment(position);
                 //第一个参数： 上次显示的Fragment
                 // 第二个参数： 当前正要显示的Fragment
                switchFragment(tempFragemnt,baseFragment);   //切换Fragment
            }
        });
        rg_main.check(R.id.rb_home);
    }

    /*
     *添加的时候要按照顺序添加
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new TaskFragment());
        fragments.add(new ManorFragment());
        fragments.add(new AssociationFragment());
        fragments.add(new UserFragment());
    }

    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    /*点击事件触动切换Frament
     *
     * */
    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (tempFragemnt != nextFragment) {
            tempFragemnt = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                //判断 nextFragment 是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前 Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前 Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }
}
