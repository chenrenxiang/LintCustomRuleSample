package com.crx.lintchecktest;

import android.annotation.SuppressLint;
import android.util.Log;

@SuppressLint("Log_Issue")
public final class LogUtil {

    public static void e(String tag, String msg){
        if(BuildConfig.DEBUG){
            Log.e(tag, msg);
        }
    }

    public static void w(String tag, String msg){
        if(BuildConfig.DEBUG){
            Log.w(tag, msg);
        }
    }

    public static void d(String tag, String msg){
        if(BuildConfig.DEBUG){
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg){
        if(BuildConfig.DEBUG){
            Log.i(tag, msg);
        }
    }

    public static void v(String tag, String msg){
        if(BuildConfig.DEBUG){
            Log.v(tag, msg);
        }
    }

    public static void wtf(String tag, String msg){
        if(BuildConfig.DEBUG){
            Log.wtf(tag, msg);
        }
    }
}
