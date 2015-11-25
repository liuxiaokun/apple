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
import com.fred.apple.view.HeadView;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import static com.fred.apple.util.Constant.BOX;
import static com.fred.apple.util.Constant.ORDER_UNIT;
import static com.fred.apple.util.Constant.YUAN;

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

        TextView pendingCount = (TextView) view.findViewById(R.id.pending_count);
        TextView sentCount = (TextView) view.findViewById(R.id.sent_count);
        TextView totalPriceCount = (TextView) view.findViewById(R.id.total_price);

        try {
            long hasSentLong = orderDao.queryBuilder().where().eq("has_sent", true)
                    .and().eq("is_deleted", false).countOf();
            Long sentBoxCount = orderDao.queryRawValue("SELECT SUM(quantity) FROM `ORDER` WHERE " +
                    "has_sent = 1 AND is_deleted = 0");
            sentCount.setText(hasSentLong + ORDER_UNIT + "(" + sentBoxCount + BOX + ")");

            long pendingLong = orderDao.queryBuilder().where().eq("has_sent", false)
                    .and().eq("is_deleted", false).countOf();
            Long pendingBoxCount = orderDao.queryRawValue("SELECT SUM(quantity) FROM `ORDER` " +
                    "WHERE has_sent = 0 AND is_deleted = 0");
            pendingCount.setText(pendingLong + ORDER_UNIT + "(" + pendingBoxCount + BOX + ")");

            Long totalPrice = orderDao.queryRawValue("SELECT SUM(total) FROM `ORDER` WHERE is_deleted = 0");
            totalPriceCount.setText(totalPrice + YUAN);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return view;
    }
}
