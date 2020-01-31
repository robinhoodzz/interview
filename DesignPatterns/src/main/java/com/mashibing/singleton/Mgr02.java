package com.mashibing.singleton;

/**
 * 跟01是一个意思
 * 只不过是使用了静态语句块而已
 * Created by Administrator on 2020/1/20.
 */
public class Mgr02 {

    private static final Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }

    /**
     * 构造方法私有化
     */
    private Mgr02() {
    }

    /**
     * 返回唯一实例
     *
     * @return Mgr01唯一的实例
     */
    public static Mgr02 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr02 m1 = Mgr02.getInstance();
        Mgr02 m2 = Mgr02.getInstance();
        //
        System.out.println(m1 == m2);
        System.out.println(m1.equals(m2));
    }

    public void m() {
        System.out.println("m");
    }

}
