package algo_2.$1_linked;

import algo_2.Node;
import algo_2.TestParent;
import org.junit.Assert;
import org.junit.Test;

/**
 * 反转链表
 * Created by Administrator on 2019/9/13.
 * 206. Reserve Linked List
 */
public class $1_ReserveIinkedList extends TestParent {


    @Test
    public void testReserveLinkedList() throws Exception {
        System.out.println(node1.toString());
        node1 = reserveLinkedList(node1);
        System.out.println(node1.toString());
        Assert.assertEquals("Node{v=5, next=Node{v=4, next=Node{v=3, next=Node{v=2, next=Node{v=1, next=null}}}}}", node1.toString());
    }

    public Node reserveLinkedList(Node head) {
        Node c = head, p = null;
        while (c != null) {
            Node x = c.next;
            c.next = p;
            p = c;
            c = x;
        }
        return p;
    }

    public Node reserveLinkedListOld(Node head) {
        if (head == null) {
            return head;
        }

        Node p = null, c = head, n = head.next;
        while (n != null) {
            c.next = p;
            p = c;
            c = n;
            n = n.next;
        }
        c.next = p;
        return c;
    }

}
