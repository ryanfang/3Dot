package com.tdtech.hilive;

import android.content.Intent;
import android.os.Bundle;

import com.tdtech.hilive.base.activity.TDBaseActivity;
import com.tdtech.hilive.home.activity.TDHomeActivity;

public class TDLauncherActivity extends TDBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        mHandler.postDelayed(loadingRun, 800);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(loadingRun);
    }

    private Runnable loadingRun = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(TDLauncherActivity.this, TDHomeActivity.class));
            finish();
        }
    };
}
