package com.barray;

import android.view.View;
import android.widget.Button;

import com.common.base.BaseActivity;
import com.common.commonutils.ToastUitl;

import butterknife.Bind;

public class TestDialogActivity extends BaseActivity {
    @Bind(R.id.dianjiaa)
    Button dianjiaa;
    @Override
    public int getLayoutId() {
        return R.layout.activity_test_dialog;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        dianjiaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUitl.showShort("你好啊！");
            }
        });
    }

//    public void testDialog(View view){
////        LoadingDialog.showDialogForLoading(TestDialogActivity.this);
////        LoadingDialog.showDialogForLoading(this,"我在加载啦。。。",false);
////        AppManager.getAppManager().preActivity();
//    }

}
