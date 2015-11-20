package com.fred.apple.util;


import android.content.Context;
import android.widget.Toast;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 5.0
 * @since 2015/11/20 14:27s
 */
public class ToastUtil {


    private ToastUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void shortShow(Context context, CharSequence message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void shortShow(Context context, int message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void longShow(Context context, CharSequence message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void longShow(Context context, int message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void show(Context context, CharSequence message, int duration) {
        Toast.makeText(context, message, duration).show();
    }

    public static void show(Context context, int message, int duration) {
        Toast.makeText(context, message, duration).show();
    }

}
