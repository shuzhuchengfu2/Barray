package com.barray;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.common.commonutils.IpUtils;
import com.common.commonutils.LogUtils;
import com.common.commonutils.NetWorkUtils;
import com.common.commonutils.ToastUitl;

public class TestToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toast);
        LogUtils.logInit(true);
        LogUtils.logd("aaaa");
        LogUtils.logd("link:"+NetWorkUtils.isLinkAvailable("http://www.baidu.com"));
        LogUtils.logd("3g:"+NetWorkUtils.is3gConnected(this));
        LogUtils.logd("connect:"+NetWorkUtils.isNetConnected(this));
        LogUtils.logd("wifi:"+NetWorkUtils.isWifiConnected(this));
    }

    public void dianji(View view){
//        ToastUitl.show(getApplicationContext()," ", Toast.LENGTH_SHORT);
//       ToastUitl.showToastWithImg(null,R.mipmap.ic_launcher);
        ToastUitl.showShort("IP:"+IpUtils.GetHostIp());
    }
}
