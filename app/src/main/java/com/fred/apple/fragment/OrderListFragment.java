package com.fred.apple.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.fred.apple.R;
import com.fred.apple.activity.MainActivity;
import com.fred.apple.activity.OrderDetailActivity;
import com.fred.apple.bean.Order;
import com.fred.apple.database.DatabaseHelper;
import com.fred.apple.util.LogUtil;
import com.fred.apple.util.StringUtil;
import com.fred.apple.util.ToastUtil;
import com.fred.apple.view.HeadView;
import com.fred.apple.view.WarningDialog;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version v1.0.0
 * @since 2015-11-04 17:40
 */
public class OrderListFragment extends Fragment {

    private MainActivity mMainActivity;

    private Dao<Order, Integer> orderDao;

    private OrderAdapter mAdapter;

    private ListView mOrderList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = ((MainActivity) getActivity());

        DatabaseHelper helper = OpenHelperManager.getHelper(mMainActivity, DatabaseHelper.class);
        orderDao = helper.getOrderDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order_list, container, false);
        HeadView headView = (HeadView) view.findViewById(R.id.head_view);
        headView.setTitleText(getResources().getString(R.string.show_orders));
        mOrderList = (ListView) view.findViewById(R.id.order_list);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            mAdapter = new OrderAdapter(orderDao.queryForEq("is_deleted", false));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mOrderList.setAdapter(mAdapter);
        mOrderList.setOnItemClickListener(new MyOnItemClickListener());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private class OrderAdapter extends ArrayAdapter<Order> {

        public OrderAdapter(List<Order> orders) {
            super(getActivity(), 0, orders);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;

            if (convertView == null) {
                convertView = mMainActivity.getLayoutInflater().inflate(R.layout.order_item, null);
                viewHolder = new ViewHolder();

                viewHolder.mTextViewName = (TextView) convertView.findViewById(R.id.name);
                viewHolder.mTextViewPhone = (TextView) convertView.findViewById(R.id.phone);
                viewHolder.mTextViewType = (TextView) convertView.findViewById(R.id.type);
                viewHolder.mTextViewAddress = (TextView) convertView.findViewById(R.id.address);
                viewHolder.buttonSend = (Button) convertView.findViewById(R.id.has_sent);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Order order = getItem(position);
            viewHolder.mTextViewAddress.setText(order.getAddress());

            viewHolder.mTextViewName.setText(order.getUserName());
            viewHolder.mTextViewPhone.setText(order.getTelephone());
            viewHolder.mTextViewType.setText(order.getType() + " * " + order.getQuantity());

            if (order.getHasSent()) {
                viewHolder.buttonSend.setText("已发货");
                viewHolder.buttonSend.setBackgroundColor(Color.parseColor("#999999"));
                viewHolder.buttonSend.setClickable(false);
            } else {
                viewHolder.buttonSend.setText("发货");
                viewHolder.buttonSend.setBackgroundColor(Color.parseColor("#009966"));
                viewHolder.buttonSend.setTag(order);
                viewHolder.buttonSend.setOnClickListener(new SendListener());
            }

            return convertView;
        }
    }

    static class ViewHolder {
        private TextView mTextViewName;
        private TextView mTextViewType;
        private TextView mTextViewPhone;
        private TextView mTextViewAddress;
        private Button buttonSend;
    }

    private class SendListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            final Button button = ((Button) view);
            final Order updateOrder = (Order) view.getTag();

            final WarningDialog warningDialog = new WarningDialog(mMainActivity);
            warningDialog.setContent("订单(" + updateOrder.getOrderId() + ")发货？");
            warningDialog.setRightButtonListener("确定", new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    warningDialog.dismiss();
                    updateOrder.setHasSent(true);
                    updateOrder.setSentTime(new Date().getTime());

                    try {
                        int update = orderDao.update(updateOrder);

                        if (update == 1) {
                            button.setBackgroundColor(Color.parseColor("#999999"));
                            button.setClickable(false);
                            ToastUtil.shortShow(mMainActivity, "发货成功！");
                        } else {
                            ToastUtil.shortShow(mMainActivity, "发货失败！");
                        }
                    } catch (SQLException e) {
                        LogUtil.e("SendListener@onClick", e.getMessage());
                        ToastUtil.shortShow(mMainActivity, "发货失败！");
                    }
                }
            });

            warningDialog.setLeftButtonListener("取消", new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    warningDialog.dismiss();
                    ToastUtil.shortShow(mMainActivity, "发货已取消！");
                }
            });
            warningDialog.show();
        }
    }

    private class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Order order = mAdapter.getItem(position);
            Intent intent = new Intent(mMainActivity, OrderDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("order", order);
            intent.putExtras(bundle);

            mMainActivity.startActivity(intent);
        }
    }
}
