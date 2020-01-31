package com.mashibing.jvm;

/**
 * https://www.bilibili.com/video/av58326021?p=2
 * -XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB -XX:+PrintGC -XX:+UseG1GC
 * -XX:+DoEscapeAnalysis -XX:+EliminateAllocations -XX:+UseTLAB -XX:+PrintGC -XX:+UseG1GC
 * 逃逸分析 标量替换 线程专有对象分配
 * 开与不开 大约差7倍的性能
 * Created by Administrator on 2020/1/20.
 */
public class TestTLAB {

    class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id=id;
            this.name = name;
        }
    }

    void alloc(int i) {
        new User(i, "name " + i);
    }


    public static void main(String[] args) {
        TestTLAB t = new TestTLAB();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            t.alloc(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }


}
