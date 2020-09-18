package com.thoughtworks.basic;

/**
 * Created by dell on 2020/9/17.
 */

import java.util.*;



public class CountWords {



    public static void main(String[] args) {

        String text = "Good morning.Have a good class."+

                "Have a good visit.Have fun";

        Map<String,Integer> map = new TreeMap<>();



        String[] words = text.split("[ \n\t\r.,;!]");

        for(int i = 0; i < words.length;i++) {

            String key = words[i].toLowerCase();



            if(key.length() > 0) {

                if(!map.containsKey(key)) {

                    map.put(key, 1);

                }

                else {//如果不是第一次出现，就把value值++，那么value值是多少就是出现了几次

                    int value = map.get(key);

                    value++;

                    map.put(key, value);

                }

            }

        }



        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();



        for(Map.Entry<String, Integer> entry:entrySet)

            System.out.println(entry.getKey()+"\t"+entry.getValue());



    }
}
