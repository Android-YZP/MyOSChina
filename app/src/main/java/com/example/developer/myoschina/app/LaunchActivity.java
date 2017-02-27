package com.example.developer.myoschina.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.developer.myoschina.R;
import com.example.developer.myoschina.app.base.BaseActivity;
import com.example.developer.myoschina.app.improve.app.AppOperator;

/**
 * 你没有做到你本来应该做到的事情,就是虚弱了你自己的力量
 */

public class LaunchActivity extends BaseActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_launch;
    }

    @Override
    protected void initData() {
        super.initData();

        AppOperator.runOnThread(new Runnable() {
            @Override
            public void run() {
//                doMerge();
            }
        });

    }
}
