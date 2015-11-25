package com.fred.apple.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/11/5 15:20
 */
@DatabaseTable(tableName = "order")
public class Order implements Serializable {

    @DatabaseField(columnName = "order_id", generatedId = true)
    private Long orderId;

    @DatabaseField(columnName = "user_name", canBeNull = false)
    private String userName;

    // address related.
    @DatabaseField(columnName = "province", canBeNull = false)
    private String province;

    @DatabaseField(columnName = "city", canBeNull = false)
    private String city;

    @DatabaseField(columnName = "area", canBeNull = false)
    private String area;

    @DatabaseField(columnName = "address", canBeNull = false)
    private String address;

    @DatabaseField(columnName = "type", canBeNull = false)
    private String type;

    @DatabaseField(columnName = "telephone", canBeNull = false)
    private String telephone;

    @DatabaseField(columnName = "has_sent", canBeNull = false, defaultValue = "false")
    private boolean hasSent;

    @DatabaseField(columnName = "has_paid", canBeNull = false, defaultValue = "true")
    private boolean hasPaid;

    @DatabaseField(columnName = "quantity", canBeNull = false)
    private Integer quantity;

    @DatabaseField(columnName = "total", canBeNull = false)
    private BigDecimal total;

    @DatabaseField(columnName = "created", canBeNull = false)
    private Long created;

    @DatabaseField(columnName = "sent_time", canBeNull = true)
    private Long sentTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public boolean isHasSent() {
        return hasSent;
    }

    public void setHasSent(boolean hasSent) {
        this.hasSent = hasSent;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getSentTime() {
        return sentTime;
    }

    public void setSentTime(Long sentTime) {
        this.sentTime = sentTime;
    }
}
