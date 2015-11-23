package com.fred.apple.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fred.apple.R;
import com.fred.apple.activity.MainActivity;
import com.fred.apple.activity.TypeActivity;
import com.fred.apple.view.HeadView;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/11/23 11:50
 */
public class SettingFragment extends Fragment implements View.OnClickListener {

    private MainActivity mMainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        HeadView headView = (HeadView) view.findViewById(R.id.head_view);
        headView.setTitleText("个性设置");

        Button addType = (Button) view.findViewById(R.id.add_type);
        Button addressManager = (Button) view.findViewById(R.id.address_manager);

        addType.setOnClickListener(this);
        addressManager.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.add_type:

                mMainActivity.launch(TypeActivity.class);
                break;
            case R.id.address_manager:
                break;
            default:
                break;
        }
    }
}
