package com.thoughtworks.basic.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dell on 2020/9/18.
 */
public class Args {
//    private String argsText;
//    public Args(String argsText){
//        this.argsText = argsText;
//    }
//    public List<String> scan() {
//        List<String> keyValues = Arrays.asList(argsText.split("-"));
//        keyValues = keyValues.stream()
//                .map(String::trim)
//                .collect(Collectors.toList());
//        return keyValues.subList(1,keyValues.size());
//    }
    private String args;
    private Schema schema;

    public Args(String argsTest, Schema schema) {
        this.args = argsTest;
        this.schema = schema;
    }

    public List<KeyValuePair> scan() {
        List<String> keyValues = Arrays.asList(args.split("-"));
        keyValues = keyValues.stream()
                .map(keyValue -> keyValue.trim())
                .collect(Collectors.toList());
        keyValues = keyValues.subList(1,keyValues.size());

        List<KeyValuePair> keyValuePairs = new ArrayList<KeyValuePair>();
        keyValues.forEach(keyValue -> {
            String[] splitKeyValue = keyValue.split(" ");
            String key = splitKeyValue[0];
            String value = splitKeyValue[1];
            keyValuePairs.add(new KeyValuePair(key,value));
        });
        return keyValuePairs;
    }

    public Object getValueOf(String flag) {
        List<KeyValuePair> keyValuePairs = scan();
        Object value =  keyValuePairs.stream()
                .filter(keyValue -> flag.equals(keyValue.getKey()))
                .findFirst()
                .map(KeyValuePair::getValue).orElse(null);

        Object type = schema.getTypeOf(flag);
        //强制类型转换
        if(type.equals(Boolean.TYPE)){
            value = Boolean.parseBoolean(value.toString());
        }
        if(type.equals(Integer.TYPE)){
            value = Integer.parseInt(value.toString());
        }
        return value;
    }
}
