package com.leetcode.linkedList.$52_add_two_numbers;

/**
 * Definition for singly-linked list.
 * <p>
 * }
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode sentinel = new ListNode(0);
        ListNode curr = sentinel;
        int sum = 0;

        while (l1 != null || l2 != null) {
            sum = sum / 10;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

        }

        if(sum / 10 == 1) {
            curr.next = new ListNode(1);
        }

        return sentinel.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;


        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        ListNode result = solution.addTwoNumbers(a1, b1);
        System.out.println(result);
    }

}