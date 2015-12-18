package com.fred.apple.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import com.fred.apple.R;
import com.fred.apple.activity.MainActivity;
import com.fred.apple.bean.OptionValue;
import com.fred.apple.bean.Order;
import com.fred.apple.database.DatabaseHelper;
import com.fred.apple.util.LogUtil;
import com.fred.apple.util.StringUtil;
import com.fred.apple.util.ToastUtil;
import com.fred.apple.view.HeadView;
import com.fred.apple.view.MyEditText;
import com.fred.apple.view.WarningDialog;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/10/27 14:57
 */
public class NewOrderFragment extends Fragment implements View.OnClickListener {

    private MainActivity mMainActivity;

    private MyEditText mEditAddress;
    private MyEditText mEditName;
    private MyEditText mEditPhone;
    private AutoCompleteTextView mEditType;
    private MyEditText mEditQty;
    private MyEditText mEditPrice;

    private Dao<Order, Integer> orderDao;
    private Dao<OptionValue, Integer> OptionValueDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = ((MainActivity) getActivity());
        DatabaseHelper databaseHelper = OpenHelperManager.getHelper(mMainActivity, DatabaseHelper.class);
        orderDao = databaseHelper.getOrderDao();
        OptionValueDao = databaseHelper.getOptionValueDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_order, container, false);
        HeadView mHeadView = ((HeadView) view.findViewById(R.id.head_view));
        mHeadView.setTitleText(getResources().getString(R.string.new_order));


        mEditAddress = (MyEditText) view.findViewById(R.id.edit_address);
        mEditAddress.setTitle("地址");

        mEditName = (MyEditText) view.findViewById(R.id.edit_name);
        mEditName.setTitle("名字");

        mEditPhone = (MyEditText) view.findViewById(R.id.edit_phone);
        mEditPhone.setTitle("手机");

        mEditType = (AutoCompleteTextView) view.findViewById(R.id.edit_type);

        mEditQty = (MyEditText) view.findViewById(R.id.edit_qty);
        mEditQty.setTitle("数量");

        mEditPrice = (MyEditText) view.findViewById(R.id.edit_price);
        mEditPrice.setInputType(InputType.TYPE_CLASS_NUMBER);
        mEditPrice.setTitle("总价");

        view.findViewById(R.id.new_order).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.new_order:

                String addressName = mEditAddress.getText().trim();
                String name = mEditName.getText().trim();
                String phone = mEditPhone.getText().trim();
                String type = mEditType.getText().toString().trim();
                String qty = mEditQty.getText().trim();
                String price = mEditPrice.getText();

                if (paramCheck(addressName,
                        name, phone, type, qty, price)) {
                    return;
                }

                Order order = new Order();
                order.setAddress(addressName);
                order.setUserName(name);
                order.setTelephone(phone);
                order.setType(type);
                order.setQuantity(Integer.valueOf(qty));
                order.setHasPaid(true);
                order.setHasSent(false);
                order.setTotal(new BigDecimal(price));
                order.setCreated(System.currentTimeMillis());

                try {
                    int result = orderDao.create(order);

                    if (result == 1) {

                        final WarningDialog warningDialog = new WarningDialog(mMainActivity);
                        warningDialog.setContent("提交订单成功！");
                        warningDialog.setRightButtonListener("确定", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                warningDialog.dismiss();
                                clearData();
                            }
                        });
                        warningDialog.show();
                    } else {
                        ToastUtil.shortShow(mMainActivity, "提交订单失败！");
                    }
                } catch (SQLException e) {
                    LogUtil.e("NewOrderFragment@onClick", e.getMessage());
                    ToastUtil.shortShow(mMainActivity, "提交订单失败！");
                }
                break;

            default:
                break;
        }
    }

    private boolean paramCheck(String addressName, String name, String phone, String type, String qty, String price) {

        if (StringUtil.isEmpty(addressName)) {
            ToastUtil.shortShow(mMainActivity, "地址不能为空!");
            return true;
        }

        if (StringUtil.isEmpty(name)) {
            ToastUtil.shortShow(mMainActivity, "姓名不能为空!");
            return true;
        }

        if (StringUtil.isEmpty(phone)) {
            ToastUtil.shortShow(mMainActivity, "手机号不能为空!");
            return true;
        }

        Pattern pattern = Pattern.compile("^1\\d{10}$");
        Matcher matcher = pattern.matcher(phone);

        if (!matcher.matches()) {
            ToastUtil.shortShow(mMainActivity, "手机格式不正确!");
            return true;
        }

        if (StringUtil.isEmpty(type)) {
            ToastUtil.shortShow(mMainActivity, "规格不能为空!");
            return true;
        }

        if (StringUtil.isEmpty(qty)) {
            ToastUtil.shortShow(mMainActivity, "数量不能为空!");
            return true;
        }

        if (StringUtil.isEmpty(price)) {
            ToastUtil.shortShow(mMainActivity, "价格不能为空!");
            return true;
        }

        return false;
    }

    private void clearData() {

        mEditAddress.setText(StringUtil.EMPTY);
        mEditName.setText(StringUtil.EMPTY);
        mEditPhone.setText(StringUtil.EMPTY);
        mEditType.setText(StringUtil.EMPTY);
        mEditQty.setText(StringUtil.EMPTY);
        mEditPrice.setText(StringUtil.EMPTY);
    }
}

