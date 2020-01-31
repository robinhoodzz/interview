package com.mashibing.singleton;

/**
 * 饿汉式
 * 类加载到内存后, 就实例一个单例, JVM保证线程安全
 * 简单实用粗暴, 推荐使用项目中使用
 * 唯一缺点: 不管是否用到, 类装载时就完成实例化
 * (相当于: 你不用的, 你装载他干啥)
 * Created by Administrator on 2020/1/20.
 */
public class Mgr01 {

    private static final Mgr01 INSTANCE = new Mgr01();

    /**
     * 构造方法私有化
     */
    private Mgr01() {
    }

    /**
     * 返回唯一实例
     *
     * @return Mgr01唯一的实例
     */
    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        //
        System.out.println(m1 == m2);
        System.out.println(m1.equals(m2));
    }

    public void m() {
        System.out.println("m");
    }

}
