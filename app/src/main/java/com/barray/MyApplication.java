package com.barray;

import com.common.baseapp.BaseApplication;
import com.common.commonutils.LogUtils;

/**
 * 作者：xiongdejin
 * 时间：2016/11/23 16:41
 * 描述：
 */

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.logInit(true);
    }
}
