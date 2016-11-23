package com.common.commonutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.common.baseapp.BaseApplication;

import java.util.Set;

/**
 * 作者：xiongdejin
 * 时间：2016/11/23 17:24
 * 描述：对SharedPreference文件中的各种类型的数据进行存取操作
 */

public class SPUtils {
    private static SharedPreferences sp;
    private static SharedPreferences customSp;
    // ================================= custom =====================================
    private static SharedPreferences getCustomSharedPreferences(String customName){
        if(customName == null) return null;
        if(customSp == null){
            customSp = BaseApplication
                    .getAppContext()
                    .getSharedPreferences(customName,Context.MODE_PRIVATE);
        }
        return customSp;
    }

    public static void setCustomString(String spName,String key,String value){
        if(spName == null || key == null) return;
        getCustomSharedPreferences(spName).edit().putString(key,value).apply();
    }

    public static String getCustomString(String spName,String key,String defValue){
        if(spName == null || key == null) return  defValue;
        return getCustomSharedPreferences(spName).getString(key,defValue);
    }

    public static void setCustomInt(String spName,String key,int value){
        if(spName == null || key == null) return;
        getCustomSharedPreferences(spName).edit().putInt(key,value).apply();
    }

    public static int getCustomInt(String spName,String key,int defValue){
        if(spName == null || key == null) return  defValue;
        return getCustomSharedPreferences(spName).getInt(key,defValue);
    }

    public static void setCustomBoolean(String spName,String key,boolean value){
        if(spName == null || key == null) return;
        getCustomSharedPreferences(spName).edit().putBoolean(key,value).apply();
    }

    public static boolean getCustomBoolean(String spName,String key,boolean defValue){
        if(spName == null || key == null) return defValue;
        return getCustomSharedPreferences(spName).getBoolean(key,defValue);
    }

    public static void  setCustomBoolean(String spName,String key,float value){
        if(spName == null || key == null) return;
        getCustomSharedPreferences(spName).edit().putFloat(key,value).apply();
    }

    public static float  getCustomBoolean(String spName,String key,float defValue){
        if(spName == null || key == null) return defValue;
        return getCustomSharedPreferences(spName).getFloat(key,defValue);
    }

    public static void setCustomLong(String spName,String key,long value){
        if(spName == null || key == null) return;
        getCustomSharedPreferences(spName).edit().putLong(key,value).apply();
    }

    public static long getCustomLong(String spName,String key,long defValue){
        if(spName == null || key == null) return defValue;
        return getCustomSharedPreferences(spName).getLong(key,defValue);
    }

    public static void setCustomSetString(String spName,String key,Set<String> value){
        if(spName == null || key == null) return;
        getCustomSharedPreferences(spName).edit().putStringSet(key,value).apply();
    }

    public static Set<String> getCustomSetString(String spName,String key,Set<String> defValue){
        if(spName == null || key == null) return defValue;
        return getCustomSharedPreferences(spName).getStringSet(key,defValue);
    }

// ================================= default =====================================

    private static void init(Context context) {
        if (sp == null) {
            sp = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getAppContext());
        }
    }

    public static void setDefaultString(String key,String value){
        if(key == null) return;
        init(BaseApplication.getAppContext());
        sp.edit().putString(key,value).apply();
    }

    public static String getDefaultString(String key,String defValue){
        if(key == null) return null;
        init(BaseApplication.getAppContext());
        return  sp.getString(key,defValue);
    }

    public static void setDefaultBoolean(String key,boolean value){
        if(key == null) return;
        init(BaseApplication.getAppContext());
        sp.edit().putBoolean(key,value).apply();
    }

    public static boolean getDefaultBoolean(String key,boolean defValue){
        if(key == null) return defValue;
        init(BaseApplication.getAppContext());
        return sp.getBoolean(key,defValue);
    }

    public static void setDefaultLong(String key,long value){
        if(key == null) return;
        init(BaseApplication.getAppContext());
        sp.edit().putLong(key,value).apply();
    }

    public static long getDefaultLong(String key,long defValue){
        if(key == null) return defValue;
        init(BaseApplication.getAppContext());
        return sp.getLong(key,defValue);
    }

    public static void setDefaultFloat(String key,float value){
        if(key == null) return;
        init(BaseApplication.getAppContext());
        sp.edit().putFloat(key,value).apply();
    }

    public static float getDefaultFloat(String key,float defValue){
        if(key == null) return defValue;
        init(BaseApplication.getAppContext());
        return sp.getFloat(key,defValue);
    }

    public static void setDefaultInt(String key,int value){
        if(key == null) return;
        init(BaseApplication.getAppContext());
        sp.edit().putInt(key,value).apply();
    }

    public static int getDefaultInt(String key,int defValue){
        if(key == null) return defValue;
        init(BaseApplication.getAppContext());
        return sp.getInt(key,defValue);
    }

    public static void setDefaultStringSet(String key,Set<String> stringSet){
        if(key == null) return;
        init(BaseApplication.getAppContext());
        sp.edit().putStringSet(key,stringSet).apply();
    }

    public static Set<String> getDefaultStringSet(String key,Set<String> defSringSet){
        if(key == null) return defSringSet;
        init(BaseApplication.getAppContext());
        return sp.getStringSet(key,defSringSet);
    }

    public static void clearDefault(){
        init(BaseApplication.getAppContext());
        sp.edit().clear();
    }
}
