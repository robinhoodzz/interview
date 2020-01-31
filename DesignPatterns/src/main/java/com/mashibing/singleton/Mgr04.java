package com.mashibing.singleton;

/**
 * lazy loading
 * 懒汉式
 * 虽然达到了按需初始化的目的, 但却带来线程不安全的问题
 * <p>
 * 也可以通过synchronized解决, 但是带来效率下降
 * 我的理解: static 方法上加 synchronized 等于类对象上加同步机制, 任何线程调用时都会尝试获取锁, 从而导致其他线程处于blocking状态, 进而导致性能下降
 * Created by Administrator on 2020/1/20.
 */
public class Mgr04 {

    private static Mgr04 INSTANCE;


    /**
     * 构造方法私有化
     */
    private Mgr04() {
    }

    /**
     * 返回唯一实例
     *
     * @return Mgr01唯一的实例
     */
    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) {
            try {  // 用于后面测试
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr04.getInstance().hashCode())).start();
        }
    }

    public void m() {
        System.out.println("m");
    }

}
