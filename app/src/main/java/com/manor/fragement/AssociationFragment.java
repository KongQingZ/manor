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
public class AssociationFragment extends BaseFragment {

    private TextView textView;
    @Override
    protected View initview() {
        Log.e(TAG,"社区的Fragment的UI被初始化");
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setText("社区内容");
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initDate() {
        super.initDate();
        Log.e(TAG,"社区的Fragment的页面数据初始化");
        textView.setText("社区内容");

    }
}
