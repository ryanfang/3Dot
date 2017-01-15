package com.tdtech.hilive.userCenter.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.Map;

/*
 *  package com.dot.show.userCenter; *
 *  Created by fangtao on 16/10/6.
 *  Copyright © 2016年 3DOT. All rights reserved.
 */
public class TDMainMenuAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> dataForItems;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        public void OnClick(int position, Uri uri);
    }

    public TDMainMenuAdapter(Context context,
                           List<Map<String, Object>> dataForItems,
                           @Nullable OnItemClickListener listener) {
        this.context = context;
        this.dataForItems = dataForItems;
        this.listener = listener;
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
