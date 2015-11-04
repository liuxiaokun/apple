package com.fred.apple.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.fred.apple.R;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0
 * @since 2015/10/27 14:57
 */
public class NewOrderFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_new_order, container, false);


        return view;
    }
}
