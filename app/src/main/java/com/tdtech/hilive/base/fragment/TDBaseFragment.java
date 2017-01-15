/**
 *
 * copyright(C)2014- 
 *
 */
package com.tdtech.hilive.base.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tdtech.hilive.BuildConfig;

/**
 * @author jixiaolong
 */
public abstract class TDBaseFragment extends Fragment {
    private final String LIFE_TAG = "==fragment life==";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if(!BuildConfig.DEBUG) Log.e(LIFE_TAG, getClass().getName() + "--onCreate--");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(!BuildConfig.DEBUG)Log.e(LIFE_TAG, getClass().getName()+"--onCreateView--");
        return null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        if(!BuildConfig.DEBUG)Log.e(LIFE_TAG, getClass().getName()+"--onActivityCreated--");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        if(!BuildConfig.DEBUG)Log.e(LIFE_TAG, getClass().getName()+"--onResume--");
        super.onResume();

    }

    @Override
    public void onPause() {
        if(!BuildConfig.DEBUG)Log.e(LIFE_TAG, getClass().getName()+"--onPause--");
        super.onPause();

    }

    @Override
    public void onDestroyView() {
        if(!BuildConfig.DEBUG)Log.e(LIFE_TAG, getClass().getName()+"--onDestroyView--");
        super.onDestroyView();
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(!BuildConfig.DEBUG)Log.e(LIFE_TAG, getClass().getName()+"--setUserVisibleHint--"+isVisibleToUser);
    }

    @Override
    public void onStart() {
        if(!BuildConfig.DEBUG)Log.e(LIFE_TAG, getClass().getName()+"--onStart--");
        super.onStart();
    }

    @Override
    public void onStop() {
        if(!BuildConfig.DEBUG)Log.e(LIFE_TAG, getClass().getName()+"--onStop--");
        super.onStop();
    }

}
