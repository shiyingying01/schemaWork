package com.thoughtworks.basic.course;

/**
 * Created by dell on 2020/9/18.
 */
public class FlagSchema {
    private final String flag;
    private final Object type;
    public FlagSchema(String flag, Object type) {
        this.flag = flag;
        this.type = type;
    }


    public Object getType(){

        return type;
    }

    public boolean equalsWith(String flag) {
            return flag.equalsIgnoreCase(this.flag);

    }
}
