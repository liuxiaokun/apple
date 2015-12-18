package com.fred.apple.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.fred.apple.R;
import com.fred.apple.activity.MainActivity;
import com.fred.apple.bean.Area;
import com.fred.apple.bean.City;
import com.fred.apple.bean.OptionValue;
import com.fred.apple.bean.Order;
import com.fred.apple.bean.Province;
import com.fred.apple.database.DatabaseHelper;
import com.fred.apple.util.LogUtil;
import com.fred.apple.util.StringUtil;
import com.fred.apple.util.ToastUtil;
import com.fred.apple.view.HeadView;
import com.fred.apple.view.MyEditText;
import com.fred.apple.view.WarningDialog;
import com.google.common.collect.Lists;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/10/27 14:57
 */
public class NewOrderFragment extends Fragment implements View.OnClickListener {

    private MainActivity mMainActivity;

    private AutoCompleteTextView mEditProvince;
    private AutoCompleteTextView mEditCity;
    private AutoCompleteTextView mEditArea;
    private EditText mEditAddress;
    private EditText mEditName;
    private EditText mEditPhone;
    private AutoCompleteTextView mEditType;
    private EditText mEditQty;
    private MyEditText mEditPrice;

//    private Dao<Province, Integer> provinceDao;
//    private Dao<City, Integer> cityDao;
//    private Dao<Area, Integer> areaDao;
    private Dao<Order, Integer> orderDao;
    private Dao<OptionValue, Integer> OptionValueDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = ((MainActivity) getActivity());
        DatabaseHelper databaseHelper = OpenHelperManager.getHelper(mMainActivity, DatabaseHelper.class);
//        provinceDao = databaseHelper.getProvinceDao();
//        cityDao = databaseHelper.getCityDao();
//        areaDao = databaseHelper.getAreaDao();
        orderDao = databaseHelper.getOrderDao();
        OptionValueDao = databaseHelper.getOptionValueDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_order, container, false);
        HeadView mHeadView = ((HeadView) view.findViewById(R.id.head_view));
        mHeadView.setTitleText(getResources().getString(R.string.new_order));

        mEditProvince = ((AutoCompleteTextView) view.findViewById(R.id.edit_province));

        mEditCity = ((AutoCompleteTextView) view.findViewById(R.id.edit_city));
        mEditCity.setOnFocusChangeListener(new CityOnFocusListener());

        mEditArea = ((AutoCompleteTextView) view.findViewById(R.id.edit_area));
        mEditArea.setOnFocusChangeListener(new AreaOnFocusListener());

        mEditAddress = ((EditText) view.findViewById(R.id.edit_address));

        mEditName = ((EditText) view.findViewById(R.id.edit_name));

        mEditPhone = ((EditText) view.findViewById(R.id.edit_phone));

        mEditType = ((AutoCompleteTextView) view.findViewById(R.id.edit_type));

        mEditQty = ((EditText) view.findViewById(R.id.edit_qty));

        mEditPrice = ((MyEditText) view.findViewById(R.id.edit_price));

        List<Province> provinces = Lists.newArrayList();
        List<OptionValue> types = Lists.newArrayList();
        try {
            provinces = provinceDao.queryBuilder().where().eq("enable", true).query();
            types = OptionValueDao.queryBuilder().where().eq("is_deleted", false).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int size = provinces.size();
        LogUtil.i("province size:", String.valueOf(size));
        String[] provincesArray = new String[size];

        for (int i = 0; i < size; i++) {
            provincesArray[i] = provinces.get(i).getProvinceName();
        }

        if (types != null && types.size() > 0) {
            String[] typesArray = new String[types.size()];

            for (int i = 0; i < types.size(); i++) {
                typesArray[i] = types.get(i).getOptionValue();
            }

            ArrayAdapter<String> typesAdapter = new ArrayAdapter<>(mMainActivity,
                    android.R.layout.simple_list_item_1, typesArray);
            mEditType.setAdapter(typesAdapter);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(mMainActivity,
                android.R.layout.simple_list_item_1, provincesArray);
        mEditProvince.setAdapter(arrayAdapter);

        mEditPrice.setInputType(InputType.TYPE_CLASS_NUMBER);
        mEditPrice.setTitle("总价");

        view.findViewById(R.id.new_order).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.new_order:

                String provinceName = mEditProvince.getText().toString();
                String cityName = mEditCity.getText().toString();
                String areaName = mEditArea.getText().toString();
                String addressName = mEditAddress.getText().toString();
                String name = mEditName.getText().toString();
                String phone = mEditPhone.getText().toString();
                String type = mEditType.getText().toString();
                String qty = mEditQty.getText().toString();
                String price = mEditPrice.getText();

                if (paramCheck(provinceName, cityName, areaName, addressName,
                        name, phone, type, qty, price)) {
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

    private boolean paramCheck(String provinceName, String cityName, String areaName, String addressName, String name, String phone, String type, String qty, String price) {

        if (StringUtil.isEmpty(provinceName)) {
            ToastUtil.shortShow(mMainActivity, "省份不能为空!");
            return true;
        }

        if (StringUtil.isEmpty(cityName)) {
            ToastUtil.shortShow(mMainActivity, "城市不能为空!");
            return true;
        }

        if (StringUtil.isEmpty(areaName)) {
            ToastUtil.shortShow(mMainActivity, "区县不能为空!");
            return true;
        }

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

        mEditProvince.setText(StringUtil.EMPTY);
        mEditCity.setText(StringUtil.EMPTY);
        mEditArea.setText(StringUtil.EMPTY);
        mEditAddress.setText(StringUtil.EMPTY);
        mEditName.setText(StringUtil.EMPTY);
        mEditPhone.setText(StringUtil.EMPTY);
        mEditType.setText(StringUtil.EMPTY);
        mEditQty.setText(StringUtil.EMPTY);
        mEditPrice.setText(StringUtil.EMPTY);
    }

    private class CityOnFocusListener implements View.OnFocusChangeListener {

        @Override
        public void onFocusChange(View view, boolean hasFocus) {

            if (hasFocus) {
                String provinceName = mEditProvince.getText().toString().trim();

                if (StringUtil.isNotEmpty(provinceName)) {
                    try {
                        Province province = provinceDao.queryBuilder().where().eq
                                ("province_name", provinceName).queryForFirst();

                        if (null == province) {
                            return;
                        }
                        List<City> cities = cityDao.queryBuilder().where().eq("province_id",
                                province.getProvinceId()).query();

                        if (cities != null && !cities.isEmpty()) {

                            int size = cities.size();
                            LogUtil.i("cities size:", String.valueOf(size));
                            String[] cityArray = new String[size];

                            for (int i = 0; i < size; i++) {
                                cityArray[i] = cities.get(i).getCityName();
                            }

                            ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(mMainActivity,
                                    android.R.layout.simple_list_item_1, cityArray);
                            mEditCity.setAdapter(cityAdapter);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private class AreaOnFocusListener implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean hasFocus) {

            if (hasFocus) {
                String cityName = mEditCity.getText().toString().trim();

                if (StringUtil.isNotEmpty(cityName)) {
                    try {
                        City city = cityDao.queryBuilder().where().eq
                                ("city_name", cityName).queryForFirst();

                        if (null == city) {
                            return;
                        }
                        List<Area> areas = areaDao.queryBuilder().where().eq("city_id",
                                city.getCityId()).query();

                        if (areas != null && !areas.isEmpty()) {

                            int size = areas.size();
                            LogUtil.i("areas size:", String.valueOf(size));
                            String[] areaArray = new String[size];

                            for (int i = 0; i < size; i++) {
                                areaArray[i] = areas.get(i).getAreaName();
                            }

                            ArrayAdapter<String> areaAdapter = new ArrayAdapter<>(mMainActivity,
                                    android.R.layout.simple_list_item_1, areaArray);
                            mEditArea.setAdapter(areaAdapter);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

