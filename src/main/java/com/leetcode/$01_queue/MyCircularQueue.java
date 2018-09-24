package com.leetcode.$01_queue;

/**
 * 循环队列
 * Created by Administrator on 2018/7/30.
 */
class MyCircularQueue {

    private int[] data = null;
    private int head = -1;
    private int tail = -1;
    private int size = 0;

    /**
     * Initialize your data structure hee. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        data = new int[k];
        size = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }


    public static void main(String[] args) {
//        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
//        System.out.println(circularQueue.enQueue(1));  // return true
//        System.out.println(circularQueue.enQueue(2));  // return true
//        System.out.println(circularQueue.enQueue(3));  // return true
//        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
//        System.out.println(circularQueue.Rear());  // return 3
//        System.out.println(circularQueue.isFull());  // return true
//        System.out.println(circularQueue.deQueue());  // return true
//        System.out.println(circularQueue.enQueue(4));  // return true
//        System.out.println(circularQueue.Rear());  // return 4


//        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
//        System.out.println(circularQueue.enQueue(1));  // return true
//        System.out.println(circularQueue.Rear());  // return true
//        System.out.println(circularQueue.enQueue(3));  // return true
//        System.out.println(circularQueue.deQueue());  // return false, the queue is full
//        System.out.println(circularQueue.Front());  // return 3
//        System.out.println(circularQueue.deQueue());  // return true
//        System.out.println(circularQueue.deQueue());  // return true
//        System.out.println(circularQueue.isEmpty());  // return true
//        System.out.println(circularQueue.deQueue());  // return 4
//        System.out.println(circularQueue.enQueue(2));  // return 4
//        System.out.println(circularQueue.enQueue(4));  // return 4


        MyCircularQueue circularQueue = new MyCircularQueue(6); // set the size to be 3
        System.out.println(circularQueue.enQueue(6));  // return true
        System.out.println(circularQueue.Rear());  // return true
        System.out.println(circularQueue.Rear());  // return true
        System.out.println(circularQueue.deQueue());  // return false, the queue is full
        System.out.println(circularQueue.enQueue(5));  // return 3
        System.out.println(circularQueue.Rear());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.Front());  // return true
        System.out.println(circularQueue.deQueue());  // return 4
        System.out.println(circularQueue.deQueue());  // return 4
        System.out.println(circularQueue.deQueue());  // return 4


    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
