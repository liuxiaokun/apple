package com.fred.apple.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 1.0.0
 * @since 2015/11/20 17:04
 */
@DatabaseTable(tableName = "option_value")
public class OptionValue implements Serializable {

    @DatabaseField(columnName = "option_value_id", generatedId = true)
    private Integer optionValueId;

    @DatabaseField(columnName = "option_id", canBeNull = false)
    private Integer optionId;

    @DatabaseField(columnName = "option_value", canBeNull = false)
    private String optionValue;

    @DatabaseField(columnName = "is_deleted", canBeNull = false, defaultValue = "false")
    private Boolean isDeleted;

    public Integer getOptionValueId() {
        return optionValueId;
    }

    public void setOptionValueId(Integer optionValueId) {
        this.optionValueId = optionValueId;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
