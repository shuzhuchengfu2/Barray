package com.barray;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.common.baserx.RxBus;
import com.common.commonutils.ImageLoaderUtils;
import com.common.commonutils.LogUtils;
import com.common.commonutils.NetWorkUtils;

public class TestToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toast);
        LogUtils.logd("aaaa");
        LogUtils.logd("link:"+NetWorkUtils.isLinkAvailable("http://www.baidu.com"));
        LogUtils.logd("3g:"+NetWorkUtils.is3gConnected(this));
        LogUtils.logd("connect:"+NetWorkUtils.isNetConnected(this));
        LogUtils.logd("wifi:"+NetWorkUtils.isWifiConnected(this));

        ImageView iv = (ImageView) findViewById(R.id.iv);
//        ImageLoaderUtils.display(this,iv,"http://avatar.csdn.net/9/7/A/1_zhangphil.jpg",0,0);
        ImageLoaderUtils.displayRoundDefault(this,iv,"http://avatar.csdn.net/9/7/A/1_zhangphil.jpg",0);
    }

    public void dianji(View view){
//        ToastUitl.show(getApplicationContext()," ", Toast.LENGTH_SHORT);
//       ToastUitl.showToastWithImg(null,R.mipmap.ic_launcher);
//        ToastUitl.showShort("IP:"+IpUtils.GetHostIp());
//        DialogPermissionUtil.PermissionDialog(this,"wifi");
        RxBus.getInstance().post(new DialogEvent("你好"));
    }
}
