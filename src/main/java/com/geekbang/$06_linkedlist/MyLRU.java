package com.geekbang.$06_linkedlist;

/**
 * LRU 缓存淘汰算法
 * <p>
 * 在链表那一节中，我提到，借助散列表，我们可以把 LRU 缓存淘汰算法的时间复杂度降低为 O(1)。现在，我们就来看看它是如何做到的。
 * <p>
 * 首先，我们来回顾一下当时我们是如何通过链表实现 LRU 缓存淘汰算法的。
 * <p>
 * 我们需要维护一个按照访问时间从大到小有序排列的链表结构。因为缓存大小有限，当缓存空间不够，需要淘汰一个数据的时候，我们就直接将链表头部的结点删除。
 * <p>
 * 当要缓存某个数据的时候，先在链表中查找这个数据。如果没有找到，则直接将数据放到链表的尾部；如果找到了，我们就把它移动到链表的尾部。
 * 因为查找数据需要遍历链表，所以单纯用链表实现的 LRU 缓存淘汰算法的时间复杂很高，是 O(n)。
 */
public class MyLRU<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    private int capacity = 0;

    public MyLRU(int size) {
        this.size = size;
    }


    class Node<T> {
        T value;
        Node<T> last;
        Node<T> next;

        Node(T value, Node<T> last, Node<T> next) {
            this.value = value;
            this.last = last;
            this.next = next;
        }

//        @Override
//        public String toString() {
//            return "Node{" +
//                    "value=" + value +
//                    ", last=" + last +
//                    ", next=" + next +
//                    '}';
//        }
    }

    public boolean pushTail(T ele) {

        if (null == head) {
            head = new Node<T>(ele, null, null);
            capacity++;
        }

        /**
         * 1. 遍历查询
         * 2. 如果存在, 记录当前位置, 并记录尾部, 然后放到尾部
         *
         */
        Node<T> point = head;
        Node<T> cur = head;
        for (int i = 0; i < capacity; i++) {
            if (point.value.equals(ele)) {
                cur = point;
            }
            point = point.next;

        }
        tail = point;

        if (cur == head) {
            Node<T> tNode = new Node<>(ele, cur, null);
            cur.next = tNode;
            tail = tNode;

        } else if (cur != head) {
            if (capacity >= size) {
//                cur.next = new Node<T>(ele, cur, null);

                head = head.next;
                tail.last = cur;
                tail = cur;

            } else {
                cur.last = cur.next;
                tail.last = cur;
                tail = cur;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MyLRU<String> lru = new MyLRU<>(5);
        lru.pushTail("1");
        lru.pushTail("2");
        lru.pushTail("3");

        System.out.println(lru);

    }

    @Override
    public String toString() {
        return "MyLRU{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}
