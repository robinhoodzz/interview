package com.designpattern.singleton;

/**
 * 单例模式 懒汉式 升级3
 * Created by Administrator on 2015/4/22.
 */
public class LazyLevelThree {
    //私有的默认构造子
    private LazyLevelThree() {

    }
    public static LazyLevelThree getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static LazyLevelThree instance = new LazyLevelThree();
    }
}
