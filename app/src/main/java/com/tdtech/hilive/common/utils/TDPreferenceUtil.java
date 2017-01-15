package com.tdtech.hilive.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class TDPreferenceUtil {
    static final String PREF_FILE_NAME = "tcgy_u_pref";

    public static SharedPreferences getSharedPreference(Context mContext){
        return mContext.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public static void putInt(String key, int value, Context mContext){
        getSharedPreference(mContext).edit().putInt(key, value).commit();
    }

    public static int getInt(String key, int defValue, Context mContext){
        return getSharedPreference(mContext).getInt(key, defValue);
    }

    public static String getString(String key, String defValue, Context mContext){
        return getSharedPreference(mContext).getString(key, defValue);
    }

    public static void putString(String key, String value, Context mContext){
        getSharedPreference(mContext).edit().putString(key, value).commit();
    }

}
