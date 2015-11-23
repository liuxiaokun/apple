package com.fred.apple.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/11/20 17:02
 */
@DatabaseTable(tableName = "option")
public class Option implements Serializable {

    @DatabaseField(columnName = "option_id", id = true)
    private Integer optionId;

    @DatabaseField(columnName = "option_name", canBeNull = false)
    private String optionName;

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
