package com.manor.fragement;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.manor.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * @author Admin
 * @version $
 * @des
 * @updateAuthor $
 * @updateDes
 */
public class TaskFragment extends BaseFragment {
    private Button task_persional;
    private Button tesk_associate;
    private TextView tv_title;
    private ImageView tv_message;
    private ImageView tv_add;
    private SearchView sv_search;
    private ImageView tb_top;

    @Override
    protected View initview() {
        Log.e(TAG, "任务的Fragment的UI被初始化");
        View view = View.inflate(mContext, R.layout.activity_task_fragment, null);   //拉去相应的fragment
        task_persional = view.findViewById(R.id.task_persional);    //个人任务
        tesk_associate = view.findViewById(R.id.tesk_associate);   //社团任务
        tv_add = view.findViewById(R.id.tv_add);           //右上角添加
        tv_message = view.findViewById(R.id.tv_message);   //左上角信息
        view.findViewById(R.id.tv_add).setVisibility(View.GONE);   //删除右上角的添加按钮
        sv_search = view.findViewById(R.id.sv_search);  //搜索框
        tb_top = view.findViewById(R.id.tb_top);        //最上面那个添加按钮
        //各种点击事件的实现
//        initListener();
        return view;
    }

    @Override
    public void initDate() {
        super.initDate();
        Log.e(TAG, "任务的Fragment的页面数据初始化");
    }
//
//    //点击事件的实现
//    private void initListener() {
//        //置顶的监听
//        //        ib_top.setOnClickListener(new View.OnClickListener() {
//        //            @Override
//        //            public void onClick(View v) {
//        //                //回到顶部
//        //                rvHome.scrollToPosition(0);
//        //            }
//        //        });
//
//        //搜素的监听
//        tb_top.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "添加", Toast.LENGTH_SHORT).show();
//            }
//        });
//        //消息的监听
//        tv_message.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "进入消息中心", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
