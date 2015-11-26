package com.fred.apple.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fred.apple.R;


/**
 * @author Fred Liu(liuxiaokun@gmail.com)
 * @version 5.0
 * @since 2015/10/16
 */
public class WarningDialog {

    private Dialog mDialog;
    private TextView mTextViewContent;
    private Button mButtonLeft;
    private Button mButtonRight;

    public WarningDialog(Context context) {

        mDialog = new Dialog(context, R.style.no_title);
        mDialog.setCancelable(false);
        initUi();
    }

    private void initUi() {

        mDialog.setContentView(R.layout.dialog_warning);

        mTextViewContent = (TextView) mDialog.findViewById(R.id.warning_content);
        mButtonLeft = (Button) mDialog.findViewById(R.id.warning_left);
        mButtonRight = (Button) mDialog.findViewById(R.id.warning_right);

    }

    public Dialog setContent(String content) {
        mTextViewContent.setText(content);
        return mDialog;
    }


    public void setLeftButtonListener(String buttonText,
                                      View.OnClickListener listener) {
        mButtonLeft.setText(buttonText);
        mButtonLeft.setOnClickListener(listener);
        mButtonLeft.setVisibility(View.VISIBLE);
    }

    public void setRightButtonListener(String buttonText,
                                       View.OnClickListener listener) {
        mButtonRight.setText(buttonText);
        mButtonRight.setOnClickListener(listener);
        mButtonRight.setVisibility(View.VISIBLE);
    }

    public void show() {
        mDialog.show();
    }

    public void dismiss() {
        mDialog.dismiss();
    }

    public boolean isShowing() {
        return mDialog.isShowing();
    }
}
