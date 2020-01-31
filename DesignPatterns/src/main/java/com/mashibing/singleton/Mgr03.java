package com.mashibing.singleton;

/**
 * lazy loading
 * 懒汉式
 * 虽然达到了按需初始化的目的, 但却带来线程不安全的问题
 * Created by Administrator on 2020/1/20.
 */
public class Mgr03 {

    private static Mgr03 INSTANCE;


    /**
     * 构造方法私有化
     */
    private Mgr03() {
    }

    /**
     * 返回唯一实例
     *
     * @return Mgr01唯一的实例
     */
    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
            try {  // 用于后面测试
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr03.getInstance().hashCode())).start();
        }
    }

    public void m() {
        System.out.println("m");
    }

}
