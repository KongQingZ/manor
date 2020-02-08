package com.manor.fragement;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.manor.R;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Admin
 * @version $
 * @des
 * @updateAuthor $
 * @updateDes
 */
public class HomeFragment extends BaseFragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private RecyclerView rv_Home;            //RecyclerView  任务列表
    private ImageView tv_add_home;      //右上角添加图标
    private TextView tv_title_home;       //标题
    private ImageView tv_message_home;      //左上角消息图标
    private TextView task_persional_home  ;  //个人任务
    private TextView  tesk_associate_home ;  //社团任务

    @Override
    protected View initview() {
        Log.e(TAG, "主页视图被初始化了");
        View view = View.inflate(mContext, R.layout.activity_home_fragment, null);
        rv_Home = view.findViewById(R.id.rv_home);
        tv_message_home =view.findViewById(R.id.tv_message);
        tv_title_home = view.findViewById(R.id.tv_title);
        tv_add_home = view.findViewById(R.id.tv_add);
        task_persional_home = view.findViewById(R.id.task_persional);
        tesk_associate_home = view.findViewById(R.id.tesk_associate);
        //设置点击事件
        initListener();
        return view;
    }

    @Override
    public void initDate() {
        super.initDate();
        Log.e(TAG, "主页数据被初始化了");
    }

    private void initListener() {
        //置顶的监听
//        ib_top.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //回到顶部
//                rvHome.scrollToPosition(0);
//            }
//        });

        //搜素的监听
        tv_add_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "添加",Toast.LENGTH_SHORT).show();
            }
        });
        //消息的监听
        tv_message_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "进入消息中心",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
