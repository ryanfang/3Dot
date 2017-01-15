/**
 * Copyright(c) 2016 micro All Rights Reserved
 */
package com.tdtech.hilive.userCenter.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tdtech.hilive.base.fragment.TDBaseFragment;


/**
 *
 * @author: (micro)micro4code@163.com
 * @date: Created: 2016年10月18日 21:41
 */
public class TDFollowFragment extends TDBaseFragment {

    public static TDFollowFragment newInstance(){
        TDFollowFragment fg = new TDFollowFragment();
        return  fg;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View layout = inflater.inflate(R.layout.pop_bottom_fragment, container,false);
//        initView(layout,inflater);
        TextView layout = new TextView(getContext());
        layout.setText("TODO");
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setGravity(Gravity.CENTER);
        return layout;
    }
}
