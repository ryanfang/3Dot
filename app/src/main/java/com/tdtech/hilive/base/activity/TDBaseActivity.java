/**
 *
 * copyright(C)2014-
 *
 */
package com.tdtech.hilive.base.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tdtech.hilive.BuildConfig;
import com.tdtech.hilive.R;
import com.tdtech.hilive.common.widgits.TDNavBarWidget.onTitleBarClickListener;
import com.tdtech.hilive.databinding.ActivityBaseBinding;

import java.lang.ref.WeakReference;

public abstract class TDBaseActivity extends AppCompatActivity implements onTitleBarClickListener {

    private final String LIFETAG = "==BaseActivity life==";

    private ActivityBaseBinding binding;
    private android.support.v4.widget.DrawerLayout parentLinearLayout;//把父类activity和子类activity的view都add到这里

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(!BuildConfig.DEBUG) Log.d(LIFETAG, getClass().getName() + "#onCreate...");
        super.onCreate(savedInstanceState);
        initContentView(R.layout.activity_base);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        if(!BuildConfig.DEBUG)Log.d(LIFETAG,getClass().getName()+"#onStart...");
        super.onStart();
    }

    @Override
    protected void onResume() {
        if(!BuildConfig.DEBUG)Log.d(LIFETAG,getClass().getName()+"#onResume...");
        super.onResume();

    }

    @Override
    protected void onPause() {
        if(!BuildConfig.DEBUG)Log.d(LIFETAG,getClass().getName()+"#onPause...");
        super.onPause();

    }

    @Override
    protected void onStop() {
        if(!BuildConfig.DEBUG)Log.d(LIFETAG,getClass().getName()+"#onStop...");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if(!BuildConfig.DEBUG)Log.d(LIFETAG,getClass().getName()+"#onDestroy...");
        super.onDestroy();
    }

    /**
     * 初始化contentview
     */
    private void initContentView(int layoutResID) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        parentLinearLayout = new android.support.v4.widget.DrawerLayout(this);
//        parentLinearLayout.setOrientation(LinearLayout.VERTICAL);
        viewGroup.addView(parentLinearLayout);
        LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
    }

    @Override
    public void setContentView(int layoutResID) {
        LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
    }

    @Override
    public void setContentView(View view) {

        parentLinearLayout.addView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {

        parentLinearLayout.addView(view, params);

    }

    //============================================================
    //menu
    //============================================================
    protected Handler mHandler = new MHandler(this);
    private static class MHandler extends Handler {
        private final WeakReference<TDBaseActivity> mActivity;
        public MHandler(TDBaseActivity activity) {
            mActivity = new WeakReference<TDBaseActivity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            TDBaseActivity base = mActivity.get();
            if(base != null) {
                base.handleMessage(msg);
            }
        }
    }

    protected void handleMessage(Message msg){

    }

    @Override
    public void onBackClick() {
        finish();
    }

    @Override
    public void onRightClick() {

    }

}
