package com.thoughtworks.basic.course;

import java.util.Set;

/**
 * Created by dell on 2020/9/18.
 */
public class Schema {
    private  Set<FlagSchema> flagSchema;

    public Schema(Set<FlagSchema> flagSchema) {

        this.flagSchema = flagSchema;
    }

    public String getTypeOf(String flag) {
        return flagSchema.stream()
                .filter(x -> x.equalsWith(flag))
                .findFirst()
                .get()
                .getType();
    }
}
