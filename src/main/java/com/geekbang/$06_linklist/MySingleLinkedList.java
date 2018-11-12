package com.geekbang.$06_linklist;

/**
 * Created by Administrator on 2018/11/9.
 */
public class MySingleLinkedList<T> {

    private Node<T> head;
    private int size;

    public static void main(String[] args) {
        MySingleLinkedList<String> link = new MySingleLinkedList<>();
        link.pushHead("2");
        link.pushHead("1");

        System.out.println(link);
        System.out.println(link.getTail());

        link.pushTail("3");
        System.out.println();
        System.out.println(link);
        System.out.println(link.getTail());

        System.out.println();
        System.out.println(link.popHead());
        System.out.println(link);


        System.out.println();
        System.out.println(link.getNode(0));


        System.out.println();
        System.out.println(link.popTail());
        System.out.println(link);
        System.out.println(link.popTail());
        System.out.println(link);


    }

    /**
     * 往头部添加元素
     *
     * @param t 数据
     * @return
     */
    private boolean pushHead(T t) {
        if (head == null) {
            head = new Node<>(t, null);
        } else {
            final Node<T> tmp = head;
            head = new Node<>(t, head);
            head.next = tmp;
        }
        size++;
        return true;
    }

    /**
     * 往尾部添加元素
     *
     * @param t 数据
     * @return
     */
    private boolean pushTail(T t) {
        Node tail = this.getTail();
        if (tail == null) {
            head = new Node<>(t, null);
        } else {
            tail.next = new Node<>(t, null);
        }
        size++;
        return true;
    }

    /**
     * 获取尾部元素
     *
     * @return
     */
    private Node<T> getTail() {
//         if(head == null)
//            return null;
        return this.getTail(head);
    }

    /**
     * 递归 获取尾部元素
     *
     * @param node 元素
     * @return
     */
    private Node<T> getTail(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        node = node.next;
        return getTail(node);
    }

    private Node<T> getNode(int n) {
        if (n <= 0) return head;
        if (n >= size) return null;

        int i = 0;
        Node<T> curr = head;
        while (i < n) {
            curr = curr.next;
            i++;
        }
        return curr;
    }

    /**
     * 删除 头部节点
     *
     * @return
     */
    private Node<T> popHead() {
        if (head == null) return null;
        if (head.next == null) {
            head = null;
            size--;
            return head;
        } else {
            final Node<T> tmp = head;
            head = head.next;
            size--;
            return tmp;
        }
    }

    private Node<T> popTail() {
        Node<T> tail = this.getTail();
//        if (tail == null)
//            return null;
        // FIXME 对head的判定
        Node<T> node = getNode(size - 2);
        node.next = null;
        size--;
        return tail;
    }

    @Override
    public String toString() {
        return "MySingleLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    class Node<E> {
        E item;
        Node<E> next;

        Node(E e, Node<E> next) {
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
}
