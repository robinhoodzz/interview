package com.leetcode.linkedList;

/**
 * Created by robin on 18/12/10.
 */
public class MyLinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        if (head.next.next == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (slow.next == null) return false;
            slow = slow.next;

            if (fast.next == null) return false;
            if (fast.next.next == null) return false;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
    }

    /**
     * 别人的, 最好的 算法
     *
     * @param head
     * @return
     */
    public boolean hasCycleBest(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * 别人的, 最好的 算法
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) return null;
        slow = head;
        if (slow == fast) return slow;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }


    public static void main(String[] args) {
        MyLinkedListCycle myLinkedListCycle = new MyLinkedListCycle();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

//        [7032,15013,6890,8877,11344,320,13037,9414,6817,1566,14907,-2756,9931,-4488,]

//        System.out.println(myLinkedListCycle.hasCycle(node1));
        System.out.println(myLinkedListCycle.detectCycle(node1).val);
    }

}
