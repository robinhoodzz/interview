package algo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 判断链表是否存在环
 * 141. Linked List Cycle (Easy)
 * <p>
 * 思路: 快慢指针
 * <p>
 * 判断指针是否相等
 * 然后再操作指针移动
 */
public class $6_LinkedListCycle {

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node node0 = new Node(1);

    @Before
    public void setUp() throws Exception {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
    }


    @Test
    public void testIsCycle() {
        boolean isCycle = isCycle(node0);
        Assert.assertTrue("", isCycle);
    }


    public boolean isCycle(Node node) {
        if (node == null) {
            return false;
        }

        Node s = node;
        Node f = node.next;

        while (s != null && f != null && f.next != null) {
            if (s == f) {
                return true;
            }
            s = s.next;
            f = f.next.next;
        }

        return false;
    }
}
