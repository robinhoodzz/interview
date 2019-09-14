package algo_2;

/**
 * Created by Administrator on 2019/9/13.
 */
public class Node {
    private int v;
    public Node next;

    public Node() {
    }

    public Node(int v) {
        this.v = v;
    }

    public Node(int v, Node next) {
        this.v = v;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "v=" + v +
                ", next=" + next +
                '}';
    }
}