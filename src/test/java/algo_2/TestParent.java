package algo_2;

import org.junit.Before;

/**
 * Created by Administrator on 2019/9/13.
 */
public class TestParent {

    protected Node node1 = null;
    protected Node node1_CA = null;
    protected Node node1_CB = null;

    @Before
    public void setUp() throws Exception {
        node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        node1_CA = new Node(3);
        Node cNodeA2 = new Node(2);
        Node cNodeA3 = new Node(0);
        Node cNodeA4 = new Node(4);
        node1_CA.next = cNodeA2;
        cNodeA2.next = cNodeA3;
        cNodeA3.next = cNodeA4;
        cNodeA4.next = cNodeA2;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        node1_CB = new Node(3);
        Node cNodeB2 = new Node(2);
        node1_CB.next = cNodeB2;
        cNodeB2.next = node1_CB;
    }
}
