package com.alibaba.$04_arraylist_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** ArrayList VS LinkedList
 * Created by Administrator on 2018/9/22.
 */
public class ListTest {

    /**
     * ArrayList和LinkedList的大致区别如下:
     * 1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
     * 2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。
     * 3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。
     */



    static final int N = 50000;

    static long timeList(List list) {
        long start = System.currentTimeMillis();
        Object o = new Object();
        for (int i = 0; i < N; i++) {
            list.add(0, o);
        }
        return System.currentTimeMillis() - start;
    }

    static long readList(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0, j = list.size(); i < j; i++) {

        }
        return System.currentTimeMillis() - start;
    }

    static List addList(List list) {
        Object o = new Object();
        for (int i = 0; i < N; i++) {
            list.add(0, o);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("ArrayList添加" + N + "条耗时：" + timeList(new ArrayList()));
        System.out.println("LinkedList添加" + N + "条耗时：" + timeList(new LinkedList()));

        List list1 = addList(new ArrayList());
        List list2 = addList(new LinkedList());
        System.out.println("ArrayList查找" + N + "条耗时：" + readList(list1));
        System.out.println("LinkedList查找" + N + "条耗时：" + timeList(list2));
    }
}


