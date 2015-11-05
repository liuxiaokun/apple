package com.fred.apple.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fred Liu (liuxiaokun@lvmama.com)
 * @version 5.0
 * @since 2015/11/5 15:20
 */
public class Order implements Serializable {

    private Long orderId;

    private String name;

    private String phone;

    private String province;

    private String city;

    private String address;

    private String type;

    private boolean hasSent;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasSent() {
        return hasSent;
    }


    public void setHasSent(boolean hasSent) {
        this.hasSent = hasSent;
    }


    public static List<Order> getOrders() {

        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setPhone("13127523649");
        order.setName("Fred");
        order.setOrderId(13465L);
        order.setProvince("山东省");
        order.setCity("栖霞市");
        order.setAddress("小刀子村");
        order.setType("15斤精美装");
        order.setHasSent(false);

        for (int i = 0; i < 30; i++) {
            orders.add(order);
        }
        return orders;
    }
}
