package com.tdtech.hilive.home.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.tdtech.hilive.R;
import com.tdtech.hilive.base.activity.TDBaseActivity;
import com.tdtech.hilive.databinding.ActivityHomeBinding;

public class TDHomeActivity extends TDBaseActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findView();
        fillData();
    }

    private void findView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
    }

    private void fillData() {

    }
}
