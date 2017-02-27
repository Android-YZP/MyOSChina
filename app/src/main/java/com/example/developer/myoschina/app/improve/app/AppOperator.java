package com.example.developer.myoschina.app.improve.app;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.google.gson.Gson;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Developer on 2017/2/27.
 */

public final class AppOperator {//不可以被继承的类
    private static ExecutorService EXECUTORS_INSTANCE;//线程池的管理
    private static Gson GSON_INSTANCE;


    public static Executor getExecutor(){
        if (EXECUTORS_INSTANCE ==null){
            synchronized (AppOperator.class){
                if (EXECUTORS_INSTANCE == null){
                    EXECUTORS_INSTANCE = Executors.newFixedThreadPool(6);//创建一个线程池

                }
            }
        }
        return EXECUTORS_INSTANCE;
    }

    //抛一个线程到线程池中
    public static void runOnThread(Runnable runnable){
        getExecutor().execute(runnable);
    }

//    public static GlideUrl getGlideUrlByUser(String url){
////        if ()
//
//    }




}
