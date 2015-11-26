package com.fred.apple.view;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 0.0.1
 * @since 2015/11/26
 */

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fred.apple.R;


public class SimpleToast {

    private static Toast mToast;

    public static void longShow(Context context, String msg) {
        initToast(context, msg);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
    }

    public static void shortShow(Context context, String msg) {
        initToast(context, msg);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    private static void initToast(Context context, String message) {

        LayoutInflater mInflater = LayoutInflater.from(context);
        View mView = mInflater.inflate(R.layout.toast_common, null);
        TextView toastMessage = (TextView) mView.findViewById(R.id.toast_message);
        toastMessage.setText(message);

        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setGravity(Gravity.CENTER, 0, 200);
    }
}

