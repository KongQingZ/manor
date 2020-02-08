package com.manor.fragement;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * @author Admin
 * @version $
 * @des
 * @updateAuthor $
 * @updateDes
 */
public class UserFragment extends BaseFragment {

    private TextView textView;
    @Override
    protected View initview() {
        Log.e(TAG,"我的的Fragment的UI被初始化");
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setText("我的内容");
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initDate() {
        super.initDate();
        Log.e(TAG,"我的的Fragment的页面数据初始化");
        textView.setText("我的内容");

    }
}
