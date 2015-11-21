package com.fred.apple.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.fred.apple.R;
import com.fred.apple.activity.MainActivity;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0
 * @since 2015/10/27 14:57
 */
public class NewOrderFragment extends Fragment implements View.OnClickListener {

    private MainActivity mMainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = ((MainActivity) getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_order, container, false);
        AutoCompleteTextView province = ((AutoCompleteTextView) view.findViewById(R.id.edit_province));

        String[] arr = {"山东省", "山西省", "哈哈哈哈"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(mMainActivity, android.R.layout.simple_list_item_1, arr);
        province.setAdapter(arrayAdapter);

        Button newOrder = (Button) view.findViewById(R.id.new_order);
        newOrder.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.new_order:
                break;

            default:
                break;
        }
    }
}
