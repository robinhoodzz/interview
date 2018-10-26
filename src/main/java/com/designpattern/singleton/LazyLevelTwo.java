package com.designpattern.singleton;

/**
 * 单例模式 懒汉式 升级2
 * Created by Administrator on 2015/4/22.
 */
public class LazyLevelTwo {
    //私有的默认构造子
    private LazyLevelTwo() {

    }
    //注意，这里没有final
    private static volatile LazyLevelTwo singleton=null;
    //静态工厂方法
    public static LazyLevelTwo getInstance() {
        if (singleton == null) {
            synchronized (LazyLevelTwo.class) {
                singleton = new LazyLevelTwo();
            }
        }
        return singleton;
    }
}
