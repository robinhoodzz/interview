package algo_2.$1_linked;

import algo_2.Node;
import algo_2.TestParent;
import org.junit.Assert;
import org.junit.Test;

/**
 * 链表交换相邻元素
 * 24. Swap Nodes in Pairs
 * Created by Administrator on 2019/9/13.
 * 1-2-3-4
 * 2-1-4-3
 */
public class $2_SwapNodeInParis extends TestParent {
    /*
    1 -> 2 -> 3 -> 4 -> 5
    0 -> 1 -> 2 -> 3 -> 4 -> 5

    /--------\
    0   1 -> 2 -> 3 -> 4 -> 5
    *   *    *

    /--------\
    0   1    2 -> 3 -> 4 -> 5
        \________/
    *   *    *

    /--------\
    0   1 <- 2 -> 3 -> 4 -> 5
        \________/
    *   *    *


    /--------\
    0   1 <- 2 -> 3 -> 4 -> 5
        \________/
    *0  *2  *1
    移动2次指针

     */




    @Test
    public void testReversePair() throws Exception {
        System.out.println(node1.toString());
        Node node = reversePair(node1);
        System.out.println(node.toString());
        Assert.assertEquals("Node{v=2, next=Node{v=1, next=Node{v=4, next=Node{v=3, next=Node{v=5, next=null}}}}}", node1.toString());
    }


    public Node reversePair(Node head) {
        Node x = new Node();
        x.next = head;
        Node c = x;
        while (c.next != null && c.next.next != null) {
            Node a = c.next;
            Node b = c.next.next;

            c.next = b;
            a.next = b.next;
            b.next = a;
            c = c.next.next; // 也就是a
        }
        return x.next;
    }

}
