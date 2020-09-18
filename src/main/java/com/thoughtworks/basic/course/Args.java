package com.thoughtworks.basic.course;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dell on 2020/9/18.
 */
public class Args {
    private String argsText;
    public Args(String argsText){
        this.argsText = argsText;
    }
    public List<String> scan() {
        List<String> keyValues = Arrays.asList(argsText.split("-"));
        keyValues = keyValues.stream()
                .map(String::trim)
                .collect(Collectors.toList());
        return keyValues.subList(1,keyValues.size());
    }
}
