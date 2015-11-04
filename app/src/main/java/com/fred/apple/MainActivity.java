package com.fred.apple;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.fred.apple.fragment.NewOrderFragment;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/10/27 13:22
 */

public class MainActivity extends Activity {

    private RadioButton mRadioButtonNewOrder;
    private RadioButton mRadioButtonShowOrders;
    private RadioGroup mRadioGroup;

    private NewOrderFragment mNewOrderFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        initEvent();
    }

    private void initUi() {
        mRadioButtonNewOrder = (RadioButton) this.findViewById(R.id.new_order);
        mRadioButtonShowOrders = (RadioButton) this.findViewById(R.id.show_orders);
        mRadioGroup = (RadioGroup) this.findViewById(R.id.tab_bottom);

        mNewOrderFragment = new NewOrderFragment();

    }

    private void initEvent() {

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {

                    case R.id.new_order:

                        if (null == mNewOrderFragment) {
                            mNewOrderFragment = new NewOrderFragment();
                        }
                        getFragmentManager().beginTransaction()
                                .replace(R.id.main_content, mNewOrderFragment).commit();
                        break;

                    case R.id.show_orders:

                        break;
                    default:
                        break;

                }
            }
        });

        mRadioButtonNewOrder.performClick();
    }


}
