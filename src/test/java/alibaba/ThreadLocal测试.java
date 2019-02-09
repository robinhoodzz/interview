//package alibaba;
//
//import static dev.练手.ThreadLocal测试.local;
//import static dev.练手.ThreadLocal测试.x;
//
///**
// * Created by robin on 19/1/29.
// */
//public class ThreadLocal测试 {
//
//
//    public static int x = 0;
//    public static ThreadLocal<Integer> local = new ThreadLocal<>();
//
//
//    public static void main(String[] args) throws InterruptedException {
//
//
//        new Thread(new MyThread()).start();
//        new Thread(new MyThread()).start();
//        new Thread(new MyThread()).start();
//        new Thread(new MyThread()).start();
//        new Thread(new MyThread()).start();
//
////        System.out.println();
////        System.out.println(x);
//
//    }
//
//}
//
//class MyThread implements Runnable {
//
//
//    @Override
//    public void run() {
//        local.set(1);
//        x++;
//        System.out.println(Thread.currentThread().getId() + "x: " + x);
//        local.set(local.get() + 1);
//        System.out.println(Thread.currentThread().getId() + "local: " + local.get());
//    }
//}
