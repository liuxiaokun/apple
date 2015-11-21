package com.fred.apple.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/11/20 16:16
 */
@DatabaseTable(tableName = "area")
public class Area implements Serializable {

    @DatabaseField(columnName = "area_id", id = true)
    private Integer areaId;

    @DatabaseField(columnName = "area_name", canBeNull = false)
    private String areaName;

    @DatabaseField(columnName = "city_id", canBeNull = false)
    private Integer cityId;

    @DatabaseField(columnName = "enable", canBeNull = false, defaultValue = "1")
    private Integer enable;

    public Area() {
        // ORMLite needs a no-arg constructor
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
