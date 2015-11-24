package com.fred.apple.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version v1.0.0
 * @since 2015-11-04 17:40
 */
public class OtherFragment extends Fragment {

    private MainActivity mMainActivity;

    private Dao<Order, Integer> orderDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = (MainActivity) getActivity();
        DatabaseHelper databaseHelper = OpenHelperManager.getHelper(mMainActivity, DatabaseHelper.class);
        orderDao = databaseHelper.getOrderDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_other, container, false);

        HeadView headView = (HeadView) view.findViewById(R.id.head_view);
        headView.setTitleText("其他选项");

        TextView peddingCount = (TextView) view.findViewById(R.id.pending_count);
        TextView sentCount = (TextView) view.findViewById(R.id.sent_count);

        try {
            long hasSentLong = orderDao.queryBuilder().where().eq("has_sent", true).countOf();
            LogUtil.d("OtherFragment@onCreateView", "hasSentLong" + hasSentLong);

            sentCount.setText(String.valueOf(hasSentLong));

            long penddingLong = orderDao.queryBuilder().where().eq("has_sent", false).countOf();
            LogUtil.d("OtherFragment@onCreateView", "penddingLong" + penddingLong);

            peddingCount.setText(String.valueOf(penddingLong));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return view;
    }
}
