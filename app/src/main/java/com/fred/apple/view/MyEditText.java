package com.fred.apple.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fred.apple.R;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/11/23 17:02
 */
public class MyEditText extends LinearLayout {

    private Context mContext;

    private TextView mTextViewTitle;
    private EditText mEditTextContent;

    public MyEditText(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }


    private void init() {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        inflater.inflate(R.layout.my_edit_text, this);

        mEditTextContent = (EditText) findViewById(R.id.content);
        mTextViewTitle = (TextView) findViewById(R.id.title);
        final View line = findViewById(R.id.line);

        mEditTextContent.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    line.setBackgroundColor(Color.parseColor("#009966"));
                } else {
                    line.setBackgroundColor(Color.parseColor("#999999"));
                }
            }
        });
    }

    public void setTitle(String text) {
        mTextViewTitle.setText(text);
    }

    public void setInputType(int type) {
        mEditTextContent.setInputType(type);
    }

    public String getText() {
        return mEditTextContent.getText().toString().trim();
    }

    public void setText(CharSequence charSequence) {
        mEditTextContent.setText(charSequence);
    }
}
