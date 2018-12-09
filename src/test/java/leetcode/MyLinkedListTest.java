package leetcode;

import com.leetcode.linkedList.MyLinkedList;
import org.junit.Test;

/**
 * Created by Administrator on 2018/12/9.
 */
public class MyLinkedListTest {


    @Test
    public void name() throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(0);
        System.out.println(myLinkedList);


        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));

        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);

        System.out.println(myLinkedList);

        myLinkedList.addAtIndex(4, 4);
//        myLinkedList.addAtIndex(0, 3);

        System.out.println(myLinkedList);


        myLinkedList.deleteAtIndex(4);
        System.out.println(myLinkedList);

    }

    @Test
    public void name2() throws Exception {
        MyLinkedList linkedList = new MyLinkedList();

        System.out.println(linkedList.get(0));
        linkedList.addAtIndex(1,2);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        linkedList.addAtIndex(0,1);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));




    }
}
