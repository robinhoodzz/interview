package com.alibaba.$06_map;

import java.util.*;

/**
 * 各种Map比较
 * Created by Administrator on 2018/9/23.
 */
public class MapTest {

    public static void main(String[] args) {
        /**
         * 一、简单介绍Map

         在讲解Map排序之前，我们先来稍微了解下map。map是键值对的集合接口，它的实现类主要包括：HashMap,TreeMap,Hashtable以及LinkedHashMap等。其中这四者的区别如下（简单介绍）：

         HashMap：我们最常用的Map，它根据key的HashCode 值来存储数据,根据key可以直接获取它的Value，同时它具有很快的访问速度。HashMap最多只允许一条记录的key值为Null(多条会覆盖);允许多条记录的Value为 Null。非同步的。

         TreeMap: 能够把它保存的记录根据key排序,默认是按升序排序，也可以指定排序的比较器，当用Iterator 遍历TreeMap时，得到的记录是排过序的。TreeMap不允许key的值为null。非同步的。

         Hashtable: 与 HashMap类似,不同的是:key和value的值均不允许为null;它支持线程的同步，即任一时刻只有一个线程能写Hashtable,因此也导致了Hashtale在写入时会比较慢。

         LinkedHashMap: 保存了记录的插入顺序，在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的.在遍历的时候会比HashMap慢。key和value均允许为空，非同步的。

         ---------------------

         本文来自 qwer_bob 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/w2393040183/article/details/78092318?utm_source=copy
         */
        MapTest test = new MapTest();
        test.treeMapSortByKey();
        System.out.println("============");
        test.treeSortByValue();

    }


    /**
     * TreeMap 排序按key
     */
    public void treeMapSortByKey() {
        Map<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("c", "3");
        treeMap.put("b", "2");
        treeMap.put("a", "1");
        treeMap.put("d", "4");

        for (String key : treeMap.keySet()) {
            System.out.println(key + "\t" + treeMap.get(key));
        }
        System.out.println("---------------------------------");


        /**
         * 重新排序
         */
        Map<String, String> treeMapDesc = new TreeMap<String, String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        /**
         * 添加原有map
         */
        treeMapDesc.putAll(treeMap);


        for (String key : treeMapDesc.keySet()) {
            System.out.println(key + "\t" + treeMap.get(key));
        }

    }


    public void treeSortByValue() {
        final Map<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("c", "3");
        treeMap.put("b", "2");
        treeMap.put("a", "1");
        treeMap.put("d", "4");

        for (String key : treeMap.keySet()) {
            System.out.println(key + "\t" + treeMap.get(key));
        }
        System.out.println("---------------------------------");

        List<Map.Entry<String, String>> list = new ArrayList(treeMap.entrySet());
        List<Map<String, String>> list2 = new ArrayList();


        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + "\t" + mapping.getValue());
        }

    }


}
