package com.leetcode.linkedList;

/**
 * Created by robin on 18/12/17.
 */
public class MyDoubleLinkedList {


    Node head = null;
    private int length = 0;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public MyDoubleLinkedList() {
    }


    public int length() {
        return length;
    }

    private Node findAtIndex(int index) {
        if (length == 0 || index > length - 1)
            return null;
        if (index <= 0)
            return head;

        Node result = head.next;
        int idx = 1;
        while (idx < index) {
            result = result.next;
            idx++;
        }
        return result;
    }

    public int get(int index) {
        Node result = findAtIndex(index);
        return result != null ? result.value : -1;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > length)
            return;

        Node nodeAtIndex = findAtIndex(index - 1);
        Node node = new Node(val);
        if (nodeAtIndex == null)
            head = node;
        else if (index == 0) {
            node.next = head;
            head = node;
        } else {
            node.next = nodeAtIndex.next;
            nodeAtIndex.next = node;
        }
        length++;
    }

    public void deleteAtIndex(int index) {
        if (length == 0 || index > length - 1 || index < 0)
            return;

        if (index == 0)
            head = head.next;
        else {
            Node nodeAtIndex = findAtIndex(index - 1);
            if (nodeAtIndex.next != null)
                nodeAtIndex.next = nodeAtIndex.next.next;
        }
        length--;
    }

    public String toString() {
        String result = "";
        if (head == null)
            return result;

        Node node = head;
        while (node != null) {
            if (result == "")
                result += head.value;
            else
                result += "->" + node.value;
            node = node.next;
        }
        return result;
    }

    public static void main(String[] args) {
        MyDoubleLinkedList doubleLinkedList = new MyDoubleLinkedList();
        doubleLinkedList.addAtHead(1);

        System.out.println(doubleLinkedList);
        doubleLinkedList.addAtHead(2);
        doubleLinkedList.addAtHead(3);
        System.out.println(doubleLinkedList);
        System.out.println("###########################");


        System.out.println(doubleLinkedList.get(0));
        System.out.println(doubleLinkedList.get(1));
        System.out.println(doubleLinkedList.get(2));
        System.out.println(doubleLinkedList.get(3));
        System.out.println("###########################");

        doubleLinkedList.addAtTail(4);
        System.out.println(doubleLinkedList);
        System.out.println("###########################");


        doubleLinkedList.addAtIndex(2, 5);
        System.out.println(doubleLinkedList);
        System.out.println("###########################");

        doubleLinkedList.deleteAtIndex(4);
        System.out.println(doubleLinkedList);
        System.out.println("###########################");

        System.out.println("###########################");
        System.out.println("###########################");
        System.out.println("###########################");
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.addAtHead(1);
        list.addAtIndex(1, 2);
        System.out.println(list.get(1));
        System.out.println(list.get(0));
        System.out.println(list.get(2));


    }
}
