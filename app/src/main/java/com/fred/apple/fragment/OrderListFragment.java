package com.fred.apple.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
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
import com.fred.apple.bean.Order;
import com.fred.apple.database.DatabaseHelper;
import com.fred.apple.util.LogUtil;
import com.fred.apple.view.HeadView;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version v1.0.0
 * @since 2015-11-04 17:40
 */
public class OrderListFragment extends Fragment {

    private MainActivity mMainActivity;

    private DatabaseHelper mDatabaseHelper;

    private Dao<Order, Integer> orderDao;

    private OrderAdapter mAdapter;

    private Button mButtonSend;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = ((MainActivity) getActivity());

        mDatabaseHelper = OpenHelperManager.getHelper(mMainActivity, DatabaseHelper.class);

        orderDao = mDatabaseHelper.getOrderDao();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order_list, container, false);
        HeadView headView = (HeadView) view.findViewById(R.id.head_view);
        ListView orderList = (ListView) view.findViewById(R.id.order_list);
        headView.setTitleText(getResources().getString(R.string.show_orders));

        try {
            mAdapter = new OrderAdapter(orderDao.queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        orderList.setAdapter(mAdapter);

        orderList.setOnItemClickListener(new MyOnItemClickListener());
        return view;
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

            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.order_item, null);
            }

            Order order = getItem(position);

            TextView name = (TextView) convertView.findViewById(R.id.name);
            TextView phone = (TextView) convertView.findViewById(R.id.phone);
            TextView type = (TextView) convertView.findViewById(R.id.type);
            TextView address = (TextView) convertView.findViewById(R.id.address);
            mButtonSend = (Button) convertView.findViewById(R.id.has_sent);

            address.setText(order.getProvince() + order.getCity() + order.getArea() + order.getAddress());

            name.setText(order.getUserName());
            phone.setText(order.getTelephone());
            type.setText(order.getType() + "*" + order.getQuantity());

            if (order.isHasSent()) {
                mButtonSend.setText("已发货");
                mButtonSend.setBackgroundColor(Color.parseColor("#999999"));
                mButtonSend.setClickable(false);
            } else {
                mButtonSend.setText("发货");
                mButtonSend.setTag(order);
                mButtonSend.setOnClickListener(new SendListener());
            }

            return convertView;
        }
    }

    private class SendListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            Order updateOrder = (Order) view.getTag();
            updateOrder.setHasSent(true);
            LogUtil.i("SendListener", updateOrder.getOrderId() + "");
            try {
                int update = orderDao.update(updateOrder);
                if (update == 1) {
                    mButtonSend.setBackgroundColor(Color.parseColor("#999999"));
                    mButtonSend.setClickable(false);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Order order = mAdapter.getItem(position);
            OrderDetailFragment orderDetailFragment = new OrderDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("order", order);
            orderDetailFragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getFragmentManager()
                    .beginTransaction();
            fragmentTransaction.replace(R.id.main_content, orderDetailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
