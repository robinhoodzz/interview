package com.leetcode.linkedList.$53_flatten_a_mutilevel_doubly_linked_list;

/**
 * Created by robin on 18/12/28.
 */

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


