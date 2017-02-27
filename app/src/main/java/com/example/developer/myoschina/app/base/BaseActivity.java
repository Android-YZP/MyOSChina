package com.example.developer.myoschina.app.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import butterknife.ButterKnife;

/**
 * 封装所有Activity的基类
 * Created by Developer on 2017/2/27.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected RequestManager mImageLoader;//图片加载器Glide的使用
    private Fragment mFragment;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        //这里始终看不懂为啥加一个if
        if (initBundle(getIntent().getExtras())) {
            setContentView(getContentView());
            initWindow();
            ButterKnife.bind(this);
            initWidget();
            initData();
        } else {
            finish();
        }

        //umeng analytics
//        MobclickAgent.setDebugMode(false);
//        MobclickAgent.openActivityDurationTrack(false);
//        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);

    }

    //添加一个fragment用作使用.
    protected void addFragment(int frameLayoutId, Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragment.isAdded()) {
                if (mFragment != null) {
                    transaction.hide(mFragment).show(fragment);//隐藏原来有的Fragment显示新添加的
                } else {
                    transaction.show(fragment);
                }
            } else {
                if (mFragment != null) {
                    transaction.hide(mFragment).add(frameLayoutId, fragment);
                } else {
                    transaction.add(frameLayoutId, fragment);
                }
            }
            //添加之后记录这个fragment
            mFragment = fragment;
            transaction.commit();
        }
    }

    protected void replaceFragment(int frameLayoutId, Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(frameLayoutId, fragment);
            transaction.commit();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onPageStart(this.mPackageNameUmeng);
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPageEnd(this.mPackageNameUmeng);
//        MobclickAgent.onPause(this);
    }


    protected void initWindow() {
    }

    protected void initWidget() {
    }

    protected void initData() {
    }


    protected boolean initBundle(Bundle extras) {
        return true;
    }

    protected abstract int getContentView();

    //获取图片加载器的使用
    public synchronized RequestManager getImageLoader(){
        if (mImageLoader == null)
                mImageLoader = Glide.with(this);
        return mImageLoader;
    }



}
