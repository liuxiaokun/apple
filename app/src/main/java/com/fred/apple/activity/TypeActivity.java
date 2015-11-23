package com.fred.apple.activity;

import android.os.Bundle;
import android.text.InputType;
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

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/11/23 16:54
 */
public class TypeActivity extends BaseActivity {

    private MyEditText mMyEditTextName;
    private MyEditText mMyEditTextPrice;
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
        mMyEditTextPrice = (MyEditText) findViewById(R.id.type_price);
        mButtonAddType = (Button) findViewById(R.id.add_type);

        mMyEditTextName.setTitle("规格");
        mMyEditTextPrice.setTitle("价格");
        mMyEditTextPrice.setInputType(InputType.TYPE_CLASS_NUMBER);

        mButtonAddType.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String typeName = mMyEditTextName.getText();

                if (StringUtil.isEmpty(typeName)) {
                    ToastUtil.shortShow(TypeActivity.this, "规格名字不能为空!");
                    return;
                }

                String typePrice = mMyEditTextPrice.getText();

                if (StringUtil.isEmpty(typePrice)) {
                    ToastUtil.shortShow(TypeActivity.this, "规格价格不能为空!");
                    return;
                }

                OptionValue optionValue = new OptionValue();
                optionValue.setOptionValue(typeName);
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
