package com.common.commonutils;


import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;

import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * JSON解析二次封装
 *
 */
public class JsonUtils {

    // 采取单例模式
    private static Gson gson = new Gson();

    private JsonUtils() {
    }

    /**
     * 将对象转为JSON串，此方法能够满足大部分需求
     * @param src
     * @return
     */
    public static String toJson(Object src) {
        if (null == src) {
            return gson.toJson(JsonNull.INSTANCE);
        }
        try {
            return gson.toJson(src);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 用来将JSON串转为对象，但此方法不可用来转带泛型的集合
     * @param json
     * @param classOfT
     * @param <T>
     * @return
     */
    public static <T> Object fromJson(String json, Class<T> classOfT) {
        try {
            return gson.fromJson(json, (Type) classOfT);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 用来将JSON串转为对象，此方法可用来转带泛型的集合，如：Type为 new
     * TypeToken<List<T>>(){}.getType()
     * ，其它类也可以用此方法调用，就是将List<T>替换为你想要转成的类
     * @param json
     * @param typeOfT
     * @return
     */
    public static Object fromJson(String json, Type typeOfT) {
        try {
            return gson.fromJson(json, typeOfT);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取json中的某个值
     * @param json
     * @param key
     * @return
     */
    public static String getStringValue(String json, String key) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getString(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取json中的list值
     *
     * @param json
     * @return
     */
    public static String getListValue(String json) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getString("list");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Double getDoubleValue(String json, String key) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getDouble(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Integer getIntValue(String json, String key) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getInt(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Long getLongValue(String json, String key) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getLong(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean getBooleanValue(String json, String key) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getBoolean(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
