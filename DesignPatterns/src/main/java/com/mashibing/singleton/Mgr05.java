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
 * Created by Administrator on 2020/1/20.
 */
public class Mgr05 {

    private static Mgr05 INSTANCE;


    /**
     * 构造方法私有化
     */
    private Mgr05() {
    }

    /**
     * 返回唯一实例
     *
     * @return Mgr01唯一的实例
     */
    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr05.class) {
                try {  // 用于后面测试
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr05.getInstance().hashCode())).start();
        }
    }

    public void m() {
        System.out.println("m");
    }

}
