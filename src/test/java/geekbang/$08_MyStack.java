package geekbang;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/11/26.
 */
public class $08_MyStack<T> {

    Object[] ele = new Object[0];
    int size = 0;

    public $08_MyStack() {
    }

    public $08_MyStack(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        $08_MyStack stack = new $08_MyStack(5);

        stack.push("3");
        stack.push("2");
        stack.push("1");

        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public T push(T e) {
        if (ele.length > size) {
            throw new RuntimeException("栈满");
        }
        Object[] newEle = new Object[ele.length + 1];
        for (int i = 0; i < ele.length; i++) {
            newEle[i] = ele[i];
        }
        newEle[ele.length] = e;
        ele = newEle;
        return e;
    }

    public T pop() {
        if (size < 0) {
            throw new RuntimeException("栈空");
        }


        Object tmp = ele[ele.length - 1];
        Object[] newEle = new Object[ele.length - 1];
        for (int i = 0; i < ele.length - 1; i++) {
            newEle[i] = ele[i];
        }
        ele = newEle;
        return (T) tmp;
    }

    @Override
    public String toString() {
        return "$08_MyStack{" +
                "ele=" + Arrays.toString(ele) +
                ", size=" + size +
                '}';
    }


}
