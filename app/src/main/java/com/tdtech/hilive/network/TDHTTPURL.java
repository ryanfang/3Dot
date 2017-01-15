package com.tdtech.hilive.network;

import android.content.Context;
import android.text.TextUtils;

import com.tdtech.hilive.common.utils.TDPreferenceUtil;

public class TDHTTPURL {
    public static String HOST = null;
    public static String HOST_DEFAULT = "http://112.124.51.225:8080/sdapi/";
    public static String RECOMMEND = "api/live/recommend";

    public static String getUrl(String prefix, Context mContext) {
        return getHOST(mContext) + prefix;
    }

    public static String getHOST(Context context) {
        if (TextUtils.isEmpty(HOST)) {
            HOST = TDPreferenceUtil.getString("HOST_DEBUG", HOST_DEFAULT, context);
        }
        return HOST;
    }

    public static void restHost(Context context) {
        HOST = TDPreferenceUtil.getString("HOST_DEBUG", HOST_DEFAULT, context);
    }
}
