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
public class $4_LinkedListCycleII extends TestParent {

    /*
    三种方法
    1. 一直到NULL
    2. 使用缓存HashSet
    3. 快慢指针
     */

    @Test
    public void testLinkedListCycle() throws Exception {
        Node b1 = linkedListCycleII(node1_CA);
        Assert.assertTrue("", node1_CA.next.equals(b1));
        Node b2 = linkedListCycleII(node1_CB);
        Assert.assertTrue("", node1_CB.equals(b2));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Node b11 = linkedListCycleIIUseSet(node1_CA);
        Assert.assertTrue("", node1_CA.next.equals(b11));
        Node b12 = linkedListCycleIIUseSet(node1_CB);
        Assert.assertTrue("", node1_CB.equals(b12));

    }

    public Node linkedListCycleII(Node head) {
        Node s = head;
        Node f = head;
        boolean isCycle = false;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                isCycle = true;
                break;
            }
        }

        if(!isCycle){
            return null;
        }

        s = head;
        while (s != f) {
            s = s.next;
            f = f.next;
        }
        return s;
    }

    public Node linkedListCycleIIUseSet(Node head) {
        Set<Node> set = new HashSet<>();
        Node c = head;
        while (c != null) {
            if (set.contains(c)) {
                return c;
            }
            set.add(c);
            c = c.next;
        }
        return null;
    }
}
