package com.example.developer.myoschina.app.improve.account;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.backup.SharedPreferencesBackupHelper;

import com.example.developer.myoschina.app.bean.User;
import com.example.developer.myoschina.app.util.TLog;

/**
 * Created by Developer on 2017/2/27.
 * 账户辅助类,用于更新用户信息和保存当前账户等操作
 */

public class AccountHelper {
    private User user;
    private Application application;
    @SuppressLint("StaticFieldLeak")
    private static AccountHelper instance;

    private AccountHelper(Application application) {
        this.application = application;
    }

    //懒汉式单例模式
    public static void init(Application application) {
        instance = new AccountHelper(application);
    }

    public static boolean isLogin() {
        return getUserId
    }

    public static String getCookie() {

    }


    public static long getUserId() {
        return getUser().getId();
    }


    public synchronized static User getUser() {
        if (instance == null) {
            TLog.error("AccountHelper instances is null, you need call init() method.");
            return new User();
        }
        return null;
    }

}
