package com.leetcode.linkedList.$53_flatten_a_mutilevel_doubly_linked_list;

/**
 * Definition for singly-linked list.
 * <p>
 * }
 */
public class Solution {

    Node pre = null;

    public Node flatten_best(Node head) {
        if (head == null) return null;


        if (pre != null) {
            pre.next = head;
            head.prev = pre;
        }

        pre = head;
        Node next = head.next;
        flatten(head.child);
        head.child = null;

        flatten(next);

        return head;


    }

    public Node flatten(Node head) {
        Node sentinel = new Node();
        sentinel.next = head;
//        head.prev = sentinel;
        subFlatten(head);
        return sentinel.next;
    }

    public Node subFlatten(Node head) {

        if (head == null) return null;

        Node next = head.next;
        if (head.child != null) {
            Node tmp = head.child;
            head.child = head.next;
            head.next = tmp;

            return subFlatten(head.child);
        }

        return subFlatten(next);

    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        Node a1 = new Node(1, null, null, null);
        Node a2 = new Node(2, null, null, null);
        Node a3 = new Node(3, null, null, null);
        Node a4 = new Node(4, null, null, null);
        Node a5 = new Node(5, null, null, null);
        Node a6 = new Node(6, null, null, null);
        Node a7 = new Node(7, null, null, null);
        Node a8 = new Node(8, null, null, null);
        Node a9 = new Node(9, null, null, null);
        Node a10 = new Node(10, null, null, null);
        Node a11 = new Node(11, null, null, null);
        Node a12 = new Node(12, null, null, null);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a3.child = a7;
        a4.next = a5;
        a5.next = a6;
        a7.next = a8;
        a8.next = a9;
        a8.child = a11;
        a9.next = a10;
        a11.next = a12;

        Node flatten = solution.flatten(a1);
        System.out.println(flatten);

    }

}