package com.designpattern.singleton;

/**
 * 单例模式 懒汉式 升级1 DCK
 * Created by Administrator on 2015/4/22.
 */
public class LazyLevelOne {
    //私有的默认构造子
    private LazyLevelOne() {

    }
    //注意，这里没有final
    private static LazyLevelOne singleton=null;
    //静态工厂方法
    public static LazyLevelOne getInstance() {
        if (singleton == null) {
            synchronized (LazyLevelOne.class) {
                singleton = new LazyLevelOne();
            }
        }
        return singleton;
    }
}
