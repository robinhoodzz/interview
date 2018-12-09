package com.leetcode.linkedList;

/**
 * Created by Administrator on 2018/12/9.
 */
public class MyLinkedList {

    private Node head;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index > size - 1) {
            return -1;
        }

        Node tmp = getNode(index);
        if (tmp != null) {
            return tmp.val;
        }

        return -1;
    }

    public Node getNode(int index) {
        Node tmp = head;
        while (index > 0) {
            if (tmp != null) {
                tmp = tmp.next;
            }
            index--;
        }
        if (tmp != null) {
            return tmp;
        }
        return null;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node next = head != null ? head : null;
        head = new Node(val, next);
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {

        if(head ==null){
            addAtHead(val);
            return;
        }

        Node tail = getNode(size - 1);
        if (null == tail) return;
        tail.next = new Node(val, null);
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        if (0 == index) {
            addAtHead(val);
            return;
        }

        Node curr = getNode(index);
        Node prev = getNode(index - 1);

        prev.next = new Node(val, curr);
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index > size - 1) return;

        if (0 == index) {
            head = head.next;
            size--;
            return;
        }

        if (size - 1 == index) {
            Node prev = getNode(index - 1);
            prev.next = null;
            size--;
            return;
        }

        Node prev = getNode(index - 1);
        Node curr = getNode(index);

        prev.next = curr.next;
        size--;
    }

    class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
