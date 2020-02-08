package com.manor.fragement;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * @author Admin
 * @version $
 * @des
 * @updateAuthor $
 * @updateDes
 */
public class ManorFragment extends BaseFragment {
    private static final String TAG = ManorFragment.class.getSimpleName();
    private TextView textView;
    @Override
    protected View initview() {
        Log.e(TAG,"庄园的Fragment的UI被初始化");
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setText("庄园内容");
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initDate() {
        super.initDate();
        Log.e(TAG,"庄园的Fragment的页面数据初始化");
        textView.setText("庄园内容");

    }
}
