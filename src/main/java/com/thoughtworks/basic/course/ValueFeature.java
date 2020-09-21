package com.thoughtworks.basic.course;

/**
 * Created by dell on 2020/9/21.
 */
public enum ValueFeature {
    //boolean默认值
    BOOLEAN(false),
    //integer默认值
    INTEGER(0),
    //string默认值
    STRING("");

    private Object defaultValue;

    ValueFeature(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public String getType() {
        return this.getDefaultValue().getClass().getTypeName();

    }
}
