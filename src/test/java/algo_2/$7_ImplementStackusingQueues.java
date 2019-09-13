package algo_2;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2019/9/13.
 */
public class $7_ImplementStackusingQueues {

    Queue<Integer> queue = new LinkedList<>();

    @Test
    public void testImplementStackusingQueues() throws Exception {


    }

    public void push(int x) {
        queue.add(x);
        // 每次从头获取, 放到队尾
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    public void pop() {
        queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }


}
