package com.thoughtworks.basic.course;

/**
 * Created by dell on 2020/9/18.
 */

import java.util.Objects;

public class KeyValuePair {
    private final String key;
    //private final String value;
    private final Object value;

    public KeyValuePair(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyValuePair that = (KeyValuePair) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
