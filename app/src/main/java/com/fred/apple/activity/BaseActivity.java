package com.fred.apple.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author Fred Liu (liuxiaokun@lvmama.com)
 * @version 5.0
 * @since 2015/11/20 14:27
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void launch(Class cla) {
        Intent intent = new Intent(this, cla);
        startActivity(intent);
    }
}
