package com.mashibing.singleton;

/**
 * lazy loading
 * 懒汉式
 * 虽然达到了按需初始化的目的, 但却带来线程不安全的问题
 * <p>
 * 也可以通过synchronized解决, 但是带来效率下降
 * 我的理解: static 方法上加 synchronized 等于类对象上加同步机制, 任何线程调用时都会尝试获取锁, 从而导致其他线程处于blocking状态, 进而导致性能下降
 * <p>
 * 这次试图通过减小 synchronized代码块的方式提高效率, 但实际上是不行的, 因为在多线程模型下, 不能保证一个实例
 * 原因: 线程A到达 if(INSTANCE==null)时通过, 阻塞在syn代码块, 线程B到达 if(INSTANCE==null)且获取到锁, 导致线程B执行new操作后, A再获取锁, 并再次执行syn块的new操作
 * <p>
 * 这次双重判断
 * <p>
 * 静态内部类的方式: JVM保证单例, 加载外部类时不会加载内部类, 第一次使用的时候才会加载, 就可以实现软加载
 * <p>
 * 最后一种, 使用枚举, 不仅可以解决线程同步, 还可以防止反序列化
 * Created by Administrator on 2020/1/20.
 */
public enum Mgr08 {

    INSTANCE;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr08.INSTANCE.hashCode())).start();
        }

        Thread.sleep(1000L);// 用于上面线程执行完毕
        Mgr08.INSTANCE.m1();
        System.out.println(Mgr08.INSTANCE.m2());
    }

    /**
     * 业务代码1
     */
    public void m1() {
        System.out.println("m1");
    }

    /**
     * 业务代码2
     *
     * @return 业务对象
     */
    public String m2() {
        return "m2";
    }


}
