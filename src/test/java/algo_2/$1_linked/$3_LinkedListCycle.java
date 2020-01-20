package algo_2.$1_linked;

import algo_2.Node;
import algo_2.TestParent;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * Created by Administrator on 2019/9/13.
 */
public class $3_LinkedListCycle extends TestParent {

    /*
    三种方法
    1. 一直到NULL
    2. 使用缓存HashSet
    3. 快慢指针
     */

    @Test
    public void testLinkedListCycle() throws Exception {
        boolean b1 = linkedListCycle(node1_CA);
        Assert.assertTrue(b1);
        boolean b2 = linkedListCycle(node1_CB);
        Assert.assertTrue(b2);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        boolean b11 = linkedListCycleUseSet(node1_CA);
        Assert.assertTrue(b11);
        boolean b12 = linkedListCycleUseSet(node1_CB);
        Assert.assertTrue(b12);
    }

    public boolean linkedListCycle(Node head) {
        Node s = head;
        Node f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                return true;
            }
        }
        return false;
    }

    public boolean linkedListCycleUseSet(Node head) {
        Set<Node> set = new HashSet<>();
        Node c = head;
        while (c != null) {
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
            c = c.next;
        }
        return false;
    }
}
