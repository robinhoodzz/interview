package com.atguigu.$06_variable;

/**
 * 成员变量 与 局部变量
 * Created by Administrator on 2018/11/10.
 */
public class Exam6 {

    static int s;
    int i;
    int j;

    {
        int i = 1;
        i++;
        j++;
        s++;
    }

    public void test(int j) {
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {
        Exam6 obj1 = new Exam6();
        Exam6 obj2 = new Exam6();

        obj1.test(10);
        obj1.test(20);
        obj2.test(30);

        System.out.println(obj1.i + "," + obj1.j + "," + obj1.s);
        System.out.println(obj2.i + "," + obj2.j + "," + obj2.s);
    }


}
