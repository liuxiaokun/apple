package com.fred.apple.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.fred.apple.R;
import com.fred.apple.bean.OptionValue;
import com.fred.apple.database.DatabaseHelper;
import com.fred.apple.view.HeadView;
import com.google.common.collect.Lists;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/11/27 16:19
 */
public class TypeListActivity extends BaseActivity {

    private ListView mListView;

    private Dao<OptionValue, Integer> optionValueDao;

    private List<OptionValue> mOptionValues = Lists.newArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_list);
        DatabaseHelper helper = OpenHelperManager.getHelper(TypeListActivity.this, DatabaseHelper
                .class);
        optionValueDao = helper.getOptionValueDao();

        try {
            mOptionValues = optionValueDao.queryForAll();
            Log.i("values size", "" + mOptionValues.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (null != mOptionValues && mOptionValues.size() > 0) {

        }

        ((HeadView) findViewById(R.id.head_view)).setTitleText("规格一览");
        mListView = ((ListView) findViewById(R.id.type_list));
    }

    @Override
    protected void onResume() {
        super.onResume();

        TypeAdapter adapter = new TypeAdapter(mOptionValues);
        mListView.setAdapter(adapter);
    }

    private class TypeAdapter extends BaseAdapter {

        private List<OptionValue> values;

        public TypeAdapter(List<OptionValue> optionValues) {
            this.values = optionValues;
        }

        @Override
        public int getCount() {
            return values.size();
        }

        @Override
        public Object getItem(int position) {
            return values.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;

            if (convertView == null) {
                convertView = LayoutInflater.from(TypeListActivity.this).inflate(
                        R.layout.type_item, null);
                viewHolder = new ViewHolder();
                viewHolder.mTextViewType = (TextView) convertView.findViewById(R.id.type_name);
                viewHolder.mButtonDelete = (Button) convertView.findViewById(R.id.delete_type);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            final OptionValue value = (OptionValue) getItem(position);

            viewHolder.mTextViewType.setText(value.getOptionValue());

            if (value.getIsDeleted()) {
                viewHolder.mButtonDelete.setText("已删除");
                viewHolder.mButtonDelete.setBackgroundColor(Color.parseColor("#999999"));
            } else {
                viewHolder.mButtonDelete.setText("删除");
                viewHolder.mButtonDelete.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Button button = (Button) v;
                        value.setIsDeleted(Boolean.TRUE);

                        try {
                            optionValueDao.update(value);
                            button.setBackgroundColor(Color.parseColor("#999999"));
                            button.setClickable(false);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            return convertView;
        }
    }

    static class ViewHolder {
        private TextView mTextViewType;
        private Button mButtonDelete;
    }

}
