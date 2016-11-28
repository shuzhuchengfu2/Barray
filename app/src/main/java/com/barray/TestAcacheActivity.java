package com.barray;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.common.commonutils.ACache;
import com.common.commonutils.LogUtils;

public class TestAcacheActivity extends AppCompatActivity {
    private ACache aCache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_acache);
        aCache = ACache.get(this);
    }

    public void testAcachePut(View view){
        LogUtils.logd("======put======");
        aCache.put("name","lisi");
    }

    public void testAcacheGet(View view){
        LogUtils.logd("======get======");
        String name = aCache.getAsString("name");
        LogUtils.logd(name);
        Throwable t = null;
        LogUtils.loge(t,"aaa",new Object());
    }


}
