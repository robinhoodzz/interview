package com.java8.$01_lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by robin on 18/10/16.
 */
public class LambdaTest {


    static List<Employee> list;

    static {
        list = Arrays.asList(
                new Employee(101, "张三", 18, 9999.99),
                new Employee(102, "李四", 59, 6666.66),
                new Employee(103, "王五", 28, 3333.33),
                new Employee(104, "赵六", 18, 7777.77),
                new Employee(105, "田七", 38, 5555.55)
        );

    }

    /**
     * 1. 先按年龄 正序排序
     * 2. 再按薪水 倒序排序
     */
    public static void test1() {
        list.sort((x, y) -> {
            if(x.getAge() == y.getAge()) {
                return -Double.compare(x.getSalary(), y.getSalary());
            } else {
                return Integer.compare(x.getAge(), y.getAge());
            }
        });

        list.forEach(System.out::println);

    }

    public static void main(String[] args) {

        test1();
    }
}
