package com.tdtech.hilive.base.adapter;


import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tdtech.hilive.userCenter.adapter.TDMainMenuAdapter;

import java.util.List;
import java.util.Map;

/*
 *  package com.tdtech.hilive.base.adapter; *
 *  Created by fangtao on 2017/1/15.
 *  Copyright © 2016年 3DOT. All rights reserved.
 */
public class TDBaseAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> dataForItems;
    private TDMainMenuAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        public void OnClick(int position, Uri uri);
    }

    public void refresh(List<Map<String, Object>> dataForItems) {
        this.dataForItems = dataForItems;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.dataForItems.size();
    }

    @Override
    public Object getItem(int position) {
        Map<String, Object> itemMap = this.dataForItems.get(position);
        return itemMap.get("item");
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            Map<String, Object> itemMap = this.dataForItems.get(position);
            convertView = (View)itemMap.get("item");
        }
        return convertView;
    }
}
