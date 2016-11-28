package com.barray;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TestDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dialog);

    }

    public void testDialog(View view){
//        LoadingDialog.showDialogForLoading(TestDialogActivity.this);
//        LoadingDialog.showDialogForLoading(this,"我在加载啦。。。",false);

    }
}
