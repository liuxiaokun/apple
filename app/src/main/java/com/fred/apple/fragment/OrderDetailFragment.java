package com.fred.apple.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fred.apple.R;

/**
 * @author Fred Liu (liuxiaokun@lvmama.com)
 * @version 5.0
 * @since 2015/11/5 15:52
 */
public class OrderDetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order_detail, container, false);

        TextView orderId = (TextView) view.findViewById(R.id.order_id);
        orderId.setText(getArguments().getLong("order_id") + "");

        return view;
    }
}
