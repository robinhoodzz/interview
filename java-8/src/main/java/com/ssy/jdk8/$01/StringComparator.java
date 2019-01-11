package com.ssy.jdk8.$01;

import java.util.*;

/**
 * Created by robin on 19/1/11.
 */
public class StringComparator {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });


        Collections.sort(names, (String o1, String o2) -> o2.compareTo(o1));

        System.out.println(names);
    }


}
