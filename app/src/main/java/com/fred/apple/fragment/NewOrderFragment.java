package com.fred.apple.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.fred.apple.R;
import com.fred.apple.activity.MainActivity;
import com.fred.apple.bean.City;
import com.fred.apple.bean.Order;
import com.fred.apple.bean.Province;
import com.fred.apple.database.DatabaseHelper;
import com.fred.apple.util.LogUtil;
import com.fred.apple.util.StringUtil;
import com.fred.apple.util.ToastUtil;
import com.fred.apple.view.HeadView;
import com.google.common.collect.Lists;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/10/27 14:57
 */
public class NewOrderFragment extends Fragment implements View.OnClickListener {

    private MainActivity mMainActivity;
    private DatabaseHelper mDatabaseHelper;

    private AutoCompleteTextView mEditProvince;
    private AutoCompleteTextView mEditCity;
    private AutoCompleteTextView mEditArea;
    private EditText mEditAddress;
    private EditText mEditName;
    private EditText mEditPhone;
    private EditText mEditType;
    private EditText mEditQty;

    private Dao<Province, Integer> provinceDao;
    private Dao<City, Integer> cityDao;
    private Dao<Order, Integer> orderDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = ((MainActivity) getActivity());
        mDatabaseHelper = OpenHelperManager.getHelper(mMainActivity, DatabaseHelper.class);
        provinceDao = mDatabaseHelper.getProvinceDao();
        cityDao = mDatabaseHelper.getCityDao();
        orderDao = mDatabaseHelper.getOrderDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_order, container, false);
        HeadView mHeadView = ((HeadView) view.findViewById(R.id.head_view));
        mHeadView.setTitleText(getResources().getString(R.string.new_order));

        mEditProvince = ((AutoCompleteTextView) view.findViewById(R.id.edit_province));
        mEditCity = ((AutoCompleteTextView) view.findViewById(R.id.edit_city));
        mEditArea = ((AutoCompleteTextView) view.findViewById(R.id.edit_area));
        mEditAddress = ((EditText) view.findViewById(R.id.edit_address));
        mEditName = ((EditText) view.findViewById(R.id.edit_name));
        mEditPhone = ((EditText) view.findViewById(R.id.edit_phone));
        mEditType = ((EditText) view.findViewById(R.id.edit_type));
        mEditQty = ((EditText) view.findViewById(R.id.edit_qty));


        List<Province> provinces = Lists.newArrayList();
        try {
            provinces = provinceDao.queryBuilder().where().eq("enable", true).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int size = provinces.size();
        LogUtil.i("province size", String.valueOf(size));
        String[] provincesArray = new String[size];

        for (int i = 0; i < size; i++) {
            provincesArray[i] = provinces.get(i).getProvinceName();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(mMainActivity,
                android.R.layout.simple_list_item_1, provincesArray);
        mEditProvince.setAdapter(arrayAdapter);

        Button newOrder = (Button) view.findViewById(R.id.new_order);
        newOrder.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.new_order:
                String provinceName = mEditProvince.getText().toString();

                if (StringUtil.isEmpty(provinceName)) {
                    ToastUtil.shortShow(mMainActivity, "省份不能为空!");
                    return;
                }
                String cityName = mEditCity.getText().toString();

                if (StringUtil.isEmpty(cityName)) {
                    ToastUtil.shortShow(mMainActivity, "城市不能为空!");
                    return;
                }

                String areaName = mEditArea.getText().toString();

                if (StringUtil.isEmpty(areaName)) {
                    ToastUtil.shortShow(mMainActivity, "区县不能为空!");
                    return;
                }

                String addressName = mEditAddress.getText().toString();

                if (StringUtil.isEmpty(addressName)) {
                    ToastUtil.shortShow(mMainActivity, "地址不能为空!");
                    return;
                }

                String name = mEditName.getText().toString();

                if (StringUtil.isEmpty(name)) {
                    ToastUtil.shortShow(mMainActivity, "姓名不能为空!");
                    return;
                }

                String phone = mEditPhone.getText().toString();

                if (StringUtil.isEmpty(phone)) {
                    ToastUtil.shortShow(mMainActivity, "手机不能为空!");
                    return;
                }

                String type = mEditType.getText().toString();

                if (StringUtil.isEmpty(type)) {
                    ToastUtil.shortShow(mMainActivity, "规格不能为空!");
                    return;
                }

                String qty = mEditQty.getText().toString();

                if (StringUtil.isEmpty(qty)) {
                    ToastUtil.shortShow(mMainActivity, "数量不能为空!");
                    return;
                }

                Order order = new Order();
                order.setProvince(provinceName);
                order.setCity(cityName);
                order.setArea(areaName);
                order.setAddress(addressName);
                order.setUserName(name);
                order.setTelephone(phone);
                order.setType(type);
                order.setQuantity(Integer.valueOf(qty));
                order.setHasPaid(true);
                order.setHasSent(false);
                order.setTotal(new BigDecimal(0));

                try {
                    orderDao.create(order);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                List<Order> orders = Lists.newArrayList();
                try {
                    orders = orderDao.queryForAll();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                orders.size();

                for (Order tem : orders) {
                    ToastUtil.shortShow(mMainActivity, tem.isHasSent() + "发货了");
                }
                break;

            default:
                break;
        }
    }
}
