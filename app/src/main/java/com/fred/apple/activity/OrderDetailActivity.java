package com.fred.apple.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fred.apple.R;
import com.fred.apple.bean.Order;
import com.fred.apple.database.DatabaseHelper;
import com.fred.apple.util.DateUtil;
import com.fred.apple.view.HeadView;
import com.fred.apple.view.SimpleToast;
import com.fred.apple.view.WarningDialog;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import static com.fred.apple.util.Constant.BOX;
import static com.fred.apple.util.Constant.HAS_PAID;
import static com.fred.apple.util.Constant.HAS_SENT;
import static com.fred.apple.util.Constant.PENDING_PAID;
import static com.fred.apple.util.Constant.PENDING_SEND;
import static com.fred.apple.util.Constant.YUAN;
import static com.fred.apple.util.StringUtil.SPACE;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 5.0
 * @since 2015/11/20 14:27s
 */
public class OrderDetailActivity extends BaseActivity implements View.OnClickListener {

    private Order mOrder;

    private Dao<Order, Integer> orderDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        DatabaseHelper databaseHelper = OpenHelperManager.getHelper(OrderDetailActivity.this,
                DatabaseHelper.class);
        orderDao = databaseHelper.getOrderDao();

        mOrder = (Order) getIntent().getSerializableExtra("order");

        ((HeadView) findViewById(R.id.head_view)).setTitleText("订单详情");
        Button deleteOrder = ((Button) findViewById(R.id.delete_order));
        deleteOrder.setOnClickListener(this);

        TextView orderId = (TextView) findViewById(R.id.order_id);
        orderId.setText(String.valueOf(mOrder.getOrderId()));

        TextView userName = (TextView) findViewById(R.id.user_name);
        userName.setText(mOrder.getUserName());

        TextView address = (TextView) findViewById(R.id.address);
        address.setText(mOrder.getProvince() + SPACE + mOrder.getCity() + SPACE + mOrder.getArea() + SPACE
                + mOrder.getAddress());

        TextView type = (TextView) findViewById(R.id.type);
        type.setText(mOrder.getType());

        TextView telephone = (TextView) findViewById(R.id.telephone);
        telephone.setText(mOrder.getTelephone());

        TextView hasSent = (TextView) findViewById(R.id.has_sent);
        hasSent.setText(mOrder.getHasSent() ? HAS_SENT : PENDING_SEND);

        TextView hasPaid = (TextView) findViewById(R.id.has_paid);
        hasPaid.setText(mOrder.getHasPaid() ? HAS_PAID : PENDING_PAID);

        TextView quantity = (TextView) findViewById(R.id.quantity);
        quantity.setText(mOrder.getQuantity() + BOX);

        TextView totalPrice = (TextView) findViewById(R.id.total_price);
        totalPrice.setText(mOrder.getTotal() + YUAN);

        TextView created = (TextView) findViewById(R.id.created);
        created.setText(DateUtil.getDateTime(mOrder.getCreated()));

        TextView sentTime = (TextView) findViewById(R.id.sent_time);

        if (mOrder.getSentTime() != null) {
            sentTime.setText(DateUtil.getDateTime(mOrder.getSentTime()));
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.delete_order:

                final WarningDialog dialog = new WarningDialog(OrderDetailActivity.this);

                if (mOrder.getHasSent()) {
                    dialog.setContent("已发货的订单不能删除！");
                    dialog.setRightButtonListener("确定", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                } else {
                    dialog.setContent("确定删除？");
                    dialog.setLeftButtonListener("取消", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.setRightButtonListener("删除", new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            mOrder.setIsDeleted(true);
                            dialog.dismiss();
                            try {
                                int update = orderDao.update(mOrder);

                                if (update == 1) {
                                    SimpleToast.shortShow(OrderDetailActivity.this, "删除成功");
                                    OrderDetailActivity.this.finish();
                                } else {
                                    SimpleToast.shortShow(OrderDetailActivity.this, "删除失败");
                                }
                            } catch (SQLException e) {
                                SimpleToast.shortShow(OrderDetailActivity.this, "删除失败");
                            }
                        }
                    });
                }
                dialog.show();
                break;

            default:
                break;
        }
    }
}
