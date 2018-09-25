package com.carllewisapps.notes.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtils {

    /**
     * Stores API Key in shared pref to
     * add it in header part of every retrofit request
     */
    public PrefUtils(){

    }

    private static SharedPreferences getSharedPref(Context context) {
        return context.getSharedPreferences("APP_PREF", Context.MODE_PRIVATE);
    }


    public static String getApiKey(Context context) {
        return getSharedPref(context).getString("API_KEY", null);
    }

    public static String storeApiKey(Context context) {
        return
    }
}
