package com.tdtech.hilive.userCenter.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tdtech.hilive.R;
import com.tdtech.hilive.base.activity.TDBaseActivity;
import com.tdtech.hilive.userCenter.adapter.TDMainMenuAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tdtech.hilive.userCenter.constant.TDMainMenuConst.MainMenuItemType_Browsed;
import static com.tdtech.hilive.userCenter.constant.TDMainMenuConst.MainMenuItemType_Couns;
import static com.tdtech.hilive.userCenter.constant.TDMainMenuConst.MainMenuItemType_DivSpace;
import static com.tdtech.hilive.userCenter.constant.TDMainMenuConst.MainMenuItemType_Income;
import static com.tdtech.hilive.userCenter.constant.TDMainMenuConst.MainMenuItemType_PlayInfo;
import static com.tdtech.hilive.userCenter.constant.TDMainMenuConst.MainMenuItemType_Settings;
import static com.tdtech.hilive.userCenter.constant.TDMainMenuConst.MainMenuItemType_ShareApp;

;

public class TDMainMenuActivity extends TDBaseActivity {

    ListView lvMainMenu;

    private LayoutInflater menuInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        findView();
        fillData();
    }

    private void findView() {
//        ButterKnife.bind(this);

        lvMainMenu = (ListView)findViewById(R.id.lvMainMenu);

        menuInflater = LayoutInflater.from(this);
    }

    private void fillData() {
        TDMainMenuAdapter menuAdapter = new TDMainMenuAdapter(this, getMenuItems(), new TDMainMenuAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int position, Uri uri) {

            }
        });
        lvMainMenu.setAdapter(menuAdapter);
    }

    private TextView tvNavTitle() {
        TextView tvTitle = new TextView(this);
        tvTitle.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        );
        tvTitle.setText(R.string.Me);
        tvTitle.setTextSize(18);
        tvTitle.setTextColor(getResources().getColor(R.color.theme));
        return tvTitle;
    }

    private List<Map<String, Object>> getMenuItems() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map1 = new HashMap<String, Object>();
        LinearLayout item1 = (LinearLayout)menuInflater.inflate(R.layout.main_menu_user_item, null);

        map1.put("item", item1);
        list.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("item_type", MainMenuItemType_PlayInfo);
        list.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("item_type", MainMenuItemType_DivSpace);
        list.add(map3);

        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("item_type", MainMenuItemType_Income);
        list.add(map4);

        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("item_type", MainMenuItemType_Couns);
        list.add(map5);

        Map<String, Object> map6 = new HashMap<String, Object>();
        map6.put("item_type", MainMenuItemType_Browsed);
        list.add(map6);

        Map<String, Object> map7 = new HashMap<String, Object>();
        map7.put("item_type", MainMenuItemType_DivSpace);
        list.add(map7);

        Map<String, Object> map8 = new HashMap<String, Object>();
        map8.put("item_type", MainMenuItemType_ShareApp);
        list.add(map8);

        Map<String, Object> map9 = new HashMap<String, Object>();
        map9.put("item_type", MainMenuItemType_Settings);
        list.add(map9);

        return list;
    }

}
