package com.fred.apple.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fred.apple.R;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/11/23 11:50
 */
public class SettingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }
}
