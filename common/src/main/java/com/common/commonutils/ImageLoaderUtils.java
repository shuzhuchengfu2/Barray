package com.common.commonutils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.common.R;

/**
 * 作者：xiongdejin
 * 时间：2016/11/24 14:11
 * 描述： 图片加载工具类 使用glide框架封装
 */

public class ImageLoaderUtils {
    /**
     *  展示图片默认走缓存
     * @param context
     * @param imageView
     * @param url
     * @param placeholder
     * @param error
     */
    public static void display(Context context, ImageView imageView, String url, int placeholder, int error) {
        if(imageView == null || context == null) return;
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(placeholder)
                .error(error)
                .crossFade()
                .into(imageView);
    }

    /**
     * 展示图片不走缓存
     * @param context
     * @param imageView
     * @param url
     * @param placeholder
     * @param error
     */
    public static void displayWithoutCache(Context context, ImageView imageView, String url, int placeholder, int error) {
        if(imageView == null || context == null) return;
        Glide.with(context)
                .load(url)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(placeholder)
                .error(error)
                .crossFade()
                .into(imageView);
    }

    /**
     *  展示图片默认的加载中的/加载失败的图片，走缓存
     * @param context
     * @param imageView
     * @param url
     */
    public static void displayDefault(Context context, ImageView imageView, String url){
        if(imageView == null || context == null) return;
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .crossFade()
                .into(imageView);
    }

    /**
     * 展示图片默认的加载中的/加载失败的图片，不走缓存
     * @param context
     * @param imageView
     * @param url
     */
    public static void displayDefaultWithoutCache(Context context, ImageView imageView, String url){
        if(imageView == null || context == null) return;
        Glide.with(context)
                .load(url)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .crossFade()
                .into(imageView);
    }

    /**
     *  展示图片(圆形)，走缓存
     * @param context
     * @param imageView
     * @param url
     * @param error
     */
    public static void displayRoundDefault(Context context,ImageView imageView,
                                           String url, int error){
        if(imageView == null || context == null) return;
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(error)
                .centerCrop()
                .transform(new GlideRoundTransformUtil(context))
                .into(imageView);
    }

    /**
     *  展示图片(圆形)，不走缓存
     * @param context
     * @param imageView
     * @param url
     * @param error
     */
    public static void displayRoundDefaultWithoutCache(Context context,ImageView imageView,
                                           String url, int error){
        if(imageView == null || context == null) return;
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .error(error)
                .centerCrop()
                .transform(new GlideRoundTransformUtil(context))
                .into(imageView);
    }














}
