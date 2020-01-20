package algo_2.$2_stack_queue;

import org.junit.Test;

import java.util.Stack;

/**
 * 用栈实现队列
 * Created by Administrator on 2019/9/13.
 */
public class $6_ImplementQueueusingStacks {
    /*
    思路: 用2个栈: input, output
    1. push都放 input栈
    2. pop时, output是否有数据? 有则pop, 没有从input导入
     */
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();


    @Test
    public void testImplementQueueusingStacks() throws Exception {

    }

    public void push(int x) {
        input.push(x);
    }

    public void pop() {
        peek();
        output.pop();
    }

    public int peek() {
        if(output.isEmpty()) {
            while (!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }
}
