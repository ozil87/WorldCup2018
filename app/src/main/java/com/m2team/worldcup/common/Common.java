package com.m2team.worldcup.common;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

public class Common {

    //------------JSON FOR GROUPS----------------
    public static final String ASIA_GROUPS_QUALIFIER = "asia_group";
    public static final String EURO_GROUPS_QUALIFIER = "euro_group";
    public static final String SOUTH_AMERICA_GROUPS_QUALIFIER = "south_america";
    public static final String CENTRAL_AMERICA_GROUPS_QUALIFIER = "central_america";
    public static final String OCEAN_GROUPS_QUALIFIER = "ocean";
    public static final String AFRICA_GROUPS_QUALIFIER = "african";

    //----------JSON FOR MATCHES----------------
    public static final String EURO_MATCHES_QUALIFIER = "EURO_MATCHES_QUALIFIER";
    public static final String ASIA_MATCHES_QUALIFIER = "ASIA_MATCHES_QUALIFIER";
    public static final String SOUT_AMERICA_MATCHES_QUALIFIER = "SOUT_AMERICA_MATCHES_QUALIFIER";
    public static final String OCENIA_MATCHES_QUALIFIER = "OCENIA_MATCHES_QUALIFIER";
    public static final String CENTRAL_MATCHES_QUALIFIER = "CENTRAL_MATCHES_QUALIFIER";
    public static final String AFRICA_MATCHES_QUALIFIER = "AFRICA_MATCHES_QUALIFIER";

    //-------JSON KEY FOR ALL TEAMS--------------
    public static final String EURO_TEAMS_QUALIFIER = "EURO_TEAMS_QUALIFIER";
    public static final String AFRICA_TEAMS_QUALIFIER = "AFRICA_TEAMS_QUALIFIER";
    public static final String ASIA_TEAMS_QUALIFIER = "ASIA_TEAMS_QUALIFIER";
    public static final String CENTRAL_AMERICA_TEAMS_QUALIFIER = "CENTRAL_AMERICA_TEAMS_QUALIFIER";
    public static final String OCENIA_TEAMS_QUALIFIER = "OCENIA_TEAMS_QUALIFIER";
    public static final String SOUTH_AMERICA_TEAMS_QUALIFIER = "SOUTH_AMERICA_TEAMS_QUALIFIER";

    //----------LINK----------------
    public static final String ASIA_QUALIFIER_LINK = "http://www.fifa.com/worldcup/preliminaries/asia/index.html";
    public static String AFRICA_QUALIFIER_LINK = "http://www.fifa.com/worldcup/preliminaries/africa/index.html";
    public static String EURO_QUALIFIER_LINK = "http://www.fifa.com/worldcup/preliminaries/europe/index.html";
    public static String OCENIA_QUALIFIER_LINK = "http://www.fifa.com/worldcup/preliminaries/oceania/index.html";
    public static String SA_QUALIFIER_LINK = "http://www.fifa.com/worldcup/preliminaries/southamerica/index.html";
    public static String CENTRAL_QUALIFIER_LINK = "http://www.fifa.com/worldcup/preliminaries/nccamerica/index.html";

    public static final String KEY_JSON_DATA = "data";
    public static final String KEY_JSON_EXPIRED = "expired";
    public static final long ONE_DAY_IN_MILLISECONDS = 24 *60 * 60 * 1000;
    public static final long ONE_MONTH_IN_MILLISECONDS = 30 * ONE_DAY_IN_MILLISECONDS;

    public static String TAB_FONT = "fonts/Proxima Nova Alt Bold.otf";
    public static String PREF_FILE_NAME = "world_cup";
    public static String TAG = "HMWC";

    public static void startActivity(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

    public static void initImageLoader(Context context, ImageLoader imageLoader, DisplayImageOptions options) {
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));

        options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                //.displayer(new RoundedBitmapDisplayer(12))
                .build();
    }

    public static String getPrefString(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    public static String getPrefString(Context context, String preference, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preference, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    public static int getPrefInt(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);
    }

    public static int getPrefInt(Context context, String preference, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preference, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);
    }

    public static long getPrefLong(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, 0);
    }

    public static long getPrefLong(Context context, String preference, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preference, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, 0);
    }

    public static boolean getPrefBoolean(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    public static boolean getPrefBoolean(Context context, String preference, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preference, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    public static void putPrefValue(Context context, String key, Object value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (value instanceof Integer)
            editor.putInt(key, Integer.parseInt(value.toString()));
        else if (value instanceof String)
            editor.putString(key, value.toString());
        else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        }
        editor.apply();
    }

    public static void putPrefValue(Context context, String preference, String key, Object value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (value instanceof Integer)
            editor.putInt(key, Integer.parseInt(value.toString()));
        else if (value instanceof String)
            editor.putString(key, value.toString());
        else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        }else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        }
        editor.apply();
    }

    public static void clearStringSet(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.apply();
    }
}
