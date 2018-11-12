package com.geekbang.$06_linkedlist;

/**
 * 设计链表
 * <p>
 * <p>
 * Created by robin on 18/11/9.
 */
public class MyLinkedList<T> {

    Node head;
    int size = 0;


    public boolean pushHead(T t) {
        if (head == null) {
            head = new Node(t, null);
        } else {
            final Node tmp = head;
            head = new Node(t, head);
            head.next = tmp;
        }
        size ++;
        return true;
    }

    public boolean pushTail(T t) {
        Node tail = this.getTail();
        if(tail == null) {
            if(head == null) {
                head = new Node(t, null);
            } else {
                final Node tmp = tail;

            }
        }
        size++;
        return true;

    }

    public Node getTail() {
        Node tmp = head;
        Node curr = head;
        while(tmp != null) {
            curr = tmp;
            tmp = tmp.next;
        }

        return curr;
    }

    public Node showTail() {
        return getTail2(head);
    }

    public Node getTail2(Node head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }

        Node tmp = head.next;

        return getTail2(tmp);
    }


    class Node<E> {
        E item;
        Node next;

        Node(E e, Node next) {
            this.item = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        MyLinkedList<String> link = new MyLinkedList<>();
        link.pushHead("1");
        link.pushHead("2");

        System.out.println(link);
//        System.out.println(link.getTail());
        System.out.println(link.showTail());

    }

}
