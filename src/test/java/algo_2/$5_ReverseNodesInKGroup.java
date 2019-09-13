package algo_2;

import org.junit.Test;

/**
 * K个一组 翻转链表
 * 25. Reverse Nodes in k-Group
 * Created by Administrator on 2019/9/13.
 */
public class $5_ReverseNodesInKGroup extends TestParent {

    /*
    https://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html
    题目：Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
　　If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
　　You may not alter the values in the nodes, only nodes itself may be changed.
　　Only constant memory is allowed.
　　For example,
　　Given this linked list: 1->2->3->4->5
　　For k = 2, you should return: 2->1->4->3->5
　　For k = 3, you should return: 3->2->1->4->5

     */

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) return head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                pre = reverse(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    /**
     * Reverse a link list between pre and next exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |
     * pre        next
     * after call pre = reverse(pre, next)
     * <p>
     * 0->3->2->1->4->5->6
     * |  |
     * pre next
     *
     * @param pre
     * @param next
     * @return the reversed list's last node, which is the precedence of parameter next
     */
    private static Node reverse(Node pre, Node next) {
        Node last = pre.next;//where first will be doomed "last"
        Node cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    @Test
    public void testReverseNodesInKGroup() throws Exception {
        Node node = reverseKGroup(node1, 3);
        System.out.println(node);
    }

}
