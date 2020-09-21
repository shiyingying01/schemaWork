package com.thoughtworks.basic.course;

/**
 * Created by dell on 2020/9/18.
 */
public class FlagSchema {
    private final String flag;
    private ValueFeature valueFeature;
    public FlagSchema(String flag, ValueFeature valueFeature) {
        this.flag = flag;
//        this.type = type;
        this.valueFeature = valueFeature;
    }


//    public Object getType(){
//
//        return type;
//    }

    public boolean equalsWith(String flag) {
            return flag.equalsIgnoreCase(this.flag);

    }

    public String getType() {
        //return type;
        return valueFeature.getType();
    }
}
