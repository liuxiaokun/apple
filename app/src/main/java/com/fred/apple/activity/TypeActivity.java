package com.fred.apple.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fred.apple.R;
import com.fred.apple.bean.OptionValue;
import com.fred.apple.database.DatabaseHelper;
import com.fred.apple.util.StringUtil;
import com.fred.apple.util.ToastUtil;
import com.fred.apple.view.HeadView;
import com.fred.apple.view.MyEditText;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/11/23 16:54
 */
public class TypeActivity extends BaseActivity {

    private MyEditText mMyEditTextName;
    private Button mButtonAddType;

    private Dao<OptionValue, Integer> optionValueDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        DatabaseHelper databaseHelper = OpenHelperManager.getHelper(TypeActivity.this,
                DatabaseHelper.class);
        optionValueDao = databaseHelper.getOptionValueDao();

        HeadView headView = (HeadView) findViewById(R.id.head_view);
        headView.setTitleText("增加规格");

        mMyEditTextName = (MyEditText) findViewById(R.id.type_name);
        mButtonAddType = (Button) findViewById(R.id.add_type);

        mMyEditTextName.setTitle("规格");

        mButtonAddType.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String typeValue = mMyEditTextName.getText().trim();

                if (StringUtil.isEmpty(typeValue)) {
                    ToastUtil.shortShow(TypeActivity.this, "规格名字不能为空!");
                    return;
                }

                Map<String, Object> params = new HashMap<>();
                params.put("option_value", typeValue);
                params.put("is_deleted", false);

                try {
                    List<OptionValue> values = optionValueDao.queryForFieldValues(params);

                    if (values.size() > 0) {
                        ToastUtil.shortShow(TypeActivity.this, "规格已经存在!");
                        return;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                OptionValue optionValue = new OptionValue();
                optionValue.setOptionValue(typeValue);
                optionValue.setOptionId(1);
                try {
                    int result = optionValueDao.create(optionValue);

                    if (1 == result) {
                        ToastUtil.shortShow(TypeActivity.this, "添加规格成功");
                    }
                    TypeActivity.this.finish();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
