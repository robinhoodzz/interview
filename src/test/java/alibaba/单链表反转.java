package alibaba;

/**
 * Created by robin on 19/1/29.
 */
public class 单链表反转 {


    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.addTail(4);

        System.out.println(list.head);
        System.out.println(list.reverse());


    }

}

class SingleLinkedList {
    Node head;
    Node tail;

    public void addTail(int x){

        Node node = new Node(x);

        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }


    public Node reverse() {

        Node newHead = null;
        Node newTail = new Node(head.value);
        Node slow = head;

        while (slow.next != null) {
            Node newNode = new Node(slow.next.value);
            newHead = newNode;
            newNode.next = newTail;
            newTail = newNode;
            slow = slow.next;
        }

        return newHead;
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                '}';
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
