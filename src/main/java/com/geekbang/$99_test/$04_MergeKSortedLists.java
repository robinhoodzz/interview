package com.geekbang.$99_test;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/2/8.
 */
public class $04_MergeKSortedLists {

    public static void main(String[] args) {

        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(4);
        ListNode nodeA3 = new ListNode(5);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;

        ListNode nodeB1 = new ListNode(1);
        ListNode nodeB2 = new ListNode(3);
        ListNode nodeB3 = new ListNode(4);
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;

        ListNode nodeC1 = new ListNode(2);
        ListNode nodeC2 = new ListNode(6);
        nodeC1.next = nodeC2;

        ListNode[] lists = new ListNode[]{nodeA1, nodeB1, nodeC1};


        mergeKLists(lists);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];





        return null;
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
