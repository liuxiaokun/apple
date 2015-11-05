package com.fred.apple.fragment;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fred.apple.R;
import com.fred.apple.bean.Order;

import java.util.List;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version v1.0.0
 * @since 2015-11-04 17:40
 */
public class OrderListFragment extends ListFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OrderAdapter adapter = new OrderAdapter(Order.getOrders());
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        Order order = (Order) getListAdapter().getItem(position);

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
            TextView hasSent = (TextView) convertView.findViewById(R.id.has_sent);

            name.setText(order.getName());
            phone.setText(order.getPhone());
            type.setText(order.getType());

            if (order.isHasSent()) {
                hasSent.setText("已经发货");
                hasSent.setTextColor(Color.parseColor("#000000"));
            } else {
                hasSent.setText("尚未发货");
                hasSent.setTextColor(Color.parseColor("#CC0033"));
            }

            return convertView;
        }
    }

}
