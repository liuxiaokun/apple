package com.fred.apple.bean;

import com.fred.apple.enums.ShippingMethod;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 5.0
 * @since 2015/11/5 15:20
 */
public class Order implements Serializable {

    private Long orderId;
    private String userName;

    // address related.
    private Integer provinceId;
    private Integer cityId;
    private Integer areaId;
    private String detail;

    private String telephone;

    private Integer productId;

    private ShippingMethod shippingMethod;

    private boolean hasSent;
    private boolean hasPaid;

    private Integer quantity;
    private BigDecimal total;


}
