package com.barray;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.common.commonutils.ToastUitl;

public class TestToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toast);

    }

    public void dianji(View view){
        ToastUitl.show(getApplicationContext()," ", Toast.LENGTH_SHORT);
//        ToastUitl.showToastWithImg(null,R.mipmap.ic_launcher);
    }
}
