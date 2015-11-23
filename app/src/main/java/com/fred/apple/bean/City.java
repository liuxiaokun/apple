package com.fred.apple.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/11/20 14:50
 */
@DatabaseTable(tableName = "city")
public class City implements Serializable {

    @DatabaseField(columnName = "city_id", id = true)
    private Integer cityId;

    @DatabaseField(columnName = "city_name", canBeNull = false)
    private String cityName;

    @DatabaseField(columnName = "province_id", canBeNull = false)
    private Integer provinceId;

    @DatabaseField(columnName = "enable", canBeNull = false, defaultValue = "true")
    private boolean enable;

    public City() {
        // ORMLite needs a no-arg constructor

    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
