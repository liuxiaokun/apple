package com.fred.apple.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fred.apple.R;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version v1.0.0
 * @since 2015-11-21 09:35
 */
public class HeadView extends RelativeLayout {

    private Context mContext;
    private TextView mTvTitle;

    public HeadView(Context context) {
        super(context);
        mContext = context;
        initUI();
    }

    public HeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initUI();
    }

    private void initUI() {

        LayoutInflater.from(mContext).inflate(R.layout.head_view, this);

        mTvTitle = (TextView) findViewById(R.id.title);

    }

    public void setTitleText(String title) {
        mTvTitle.setText(title);
    }
}
