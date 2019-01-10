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
     * 返回循环链表的 开始循环的节点
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

    /**
     * 两个链表交汇, 返回交汇节点
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2) {
            // 可以使用三元运算符
            if (node1 == null) node1 = headB;
            else node1 = node1.next;

            if (node2 == null) node2 = headA;
            else node2 = node2.next;
        }

        return node1;
    }

    //
//        if (head == null) return null;
//        if (head.val == n) {
//            head = head.next;
//            return head;
//        }
//
//        ListNode last = head;
//        ListNode curr = head.next;
//        while (curr != null) {
//            if(curr.val == n) {
//                last.next = curr.next;
//                return head;
//            }
//
//            last = last.next;
//            curr = curr.next;
//        }
//
//        return head;

    /**
     * 删除第N个节点
     *
     * @param head 头
     * @param n    值
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;

        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }


        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }


        slow.next = slow.next.next;

        return head;
    }

    /**
     * 链表反转
     *
     * @param head 头
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            slow.next = slow.next.next;
            fast.next = head;
            head = fast;

            fast = slow.next;
        }
        return head;
    }

    /**
     * 移除链表中 对应值的元素
     *
     * @param head 链表头
     * @param val  值
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

//        if (head == null) return null;
//        if (head.val == val) {
//            head = head.next;
//            return head;
//        }

        ListNode start = new ListNode(0);
        start.next = head;

        ListNode slow = start;
        ListNode fast = start.next;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = fast;
                fast = fast.next;
            }

        }
        return start.next;
    }

    /**
     * 链表 奇偶下标 排列
     *
     * @param head 头
     * @return
     */
    public ListNode oddEvenList(ListNode head) {

        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = head.next;


        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }

    /**
     * 探测 链表是否是回文数
     *
     * @param head 链表头
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        /** 处理奇数 数量的链表, 因为反转过程要跳过这个节点 */
        if (fast != null) {
            slow = slow.next;
        }

        slow = this.reverseForIsPalindrome(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverseForIsPalindrome(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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


        System.out.println(myLinkedListCycle.hasCycle(node1));
        System.out.println(myLinkedListCycle.detectCycle(node1).val);
        System.out.println("##############################");

        ////////////////////////////////////////////////////////////////////////////////////////////////////

        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(2);

        ListNode nodeB1 = new ListNode(3);
        ListNode nodeB2 = new ListNode(4);
        ListNode nodeB3 = new ListNode(5);


        ListNode nodeC1 = new ListNode(6);
        ListNode nodeC2 = new ListNode(7);
        ListNode nodeC3 = new ListNode(8);

        nodeA1.next = nodeA2;

        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;

        nodeA2.next = nodeC1;
        nodeB3.next = nodeC1;

        nodeC1.next = nodeC2;
        nodeC2.next = nodeC3;


        System.out.println(myLinkedListCycle.getIntersectionNode(nodeA1, nodeB2).val);
        System.out.println("##############################");

        MyLinkedListCycle linkedList = new MyLinkedListCycle();
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(2);
        ListNode nodeC = new ListNode(3);
        ListNode nodeD = new ListNode(4);
        ListNode nodeE = new ListNode(5);


        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        ListNode head = linkedList.removeNthFromEnd(nodeA, 2);
        System.out.println(head);
        System.out.println("##############################");

        ListNode nodeTmpA = new ListNode(1);
        ListNode nodeTmpB = new ListNode(2);
        ListNode nodeTmpC = new ListNode(3);
        ListNode nodeTmpD = new ListNode(4);
        ListNode nodeTmpE = new ListNode(5);
        nodeTmpA.next = nodeTmpB;
        nodeTmpB.next = nodeTmpC;
        nodeTmpC.next = nodeTmpD;
        nodeTmpD.next = nodeTmpE;

        ListNode listNodeTmp = linkedList.reverseList(nodeTmpA);
        System.out.println(listNodeTmp);


        System.out.println("##############################");

        ListNode nodeDEL1 = new ListNode(1);
        ListNode nodeDEL2 = new ListNode(2);
        ListNode nodeDEL3 = new ListNode(6);
        ListNode nodeDEL4 = new ListNode(3);
        ListNode nodeDEL5 = new ListNode(4);
        ListNode nodeDEL6 = new ListNode(5);
        ListNode nodeDEL7 = new ListNode(6);
        nodeDEL1.next = nodeDEL2;
        nodeDEL2.next = nodeDEL3;
        nodeDEL3.next = nodeDEL4;
        nodeDEL4.next = nodeDEL5;
        nodeDEL5.next = nodeDEL6;
        nodeDEL6.next = nodeDEL7;

        ListNode nodeDEL11 = new ListNode(1);
        ListNode nodeDEL12 = new ListNode(1);
        nodeDEL11.next = nodeDEL12;

        ListNode nodeDEL0 = linkedList.removeElements(nodeDEL1, 6);
//        ListNode nodeDEL0 = linkedList.removeElements(nodeDEL11, 1);
        System.out.println(nodeDEL0);

        System.out.println("##############################");


        ListNode nodeOddEven1 = new ListNode(1);
        ListNode nodeOddEven2 = new ListNode(2);
        ListNode nodeOddEven3 = new ListNode(3);
        ListNode nodeOddEven4 = new ListNode(4);
        ListNode nodeOddEven5 = new ListNode(5);
//        ListNode nodeOddEven6 = new ListNode(5);
//        ListNode nodeOddEven7 = new ListNode(6);
        nodeOddEven1.next = nodeOddEven2;
        nodeOddEven2.next = nodeOddEven3;
        nodeOddEven3.next = nodeOddEven4;
        nodeOddEven4.next = nodeOddEven5;


        ListNode nodeOddEven0 = linkedList.oddEvenList(nodeOddEven1);
        System.out.println(nodeOddEven0);


        ListNode nodePal1 = new ListNode(1);
        ListNode nodePal2 = new ListNode(2);
        ListNode nodePal3 = new ListNode(2);
        ListNode nodePal4 = new ListNode(1);

        nodePal1.next = nodePal2;
        nodePal2.next = nodePal3;
        nodePal3.next = nodePal4;


        boolean nodePal0 = linkedList.isPalindrome(nodePal1);
        System.out.println(nodePal0);

    }

}
