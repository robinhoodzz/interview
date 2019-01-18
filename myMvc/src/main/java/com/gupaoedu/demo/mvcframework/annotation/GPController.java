package com.gupaoedu.demo.mvcframework.annotation;

import java.lang.annotation.*;

/**
 * Created by robin on 19/1/18.
 */
@Target({ElementType.TYPE}) // 只能在类上, 不能在属性和方法上
@Retention(RetentionPolicy.RUNTIME)// 运行时阶段可用
@Documented
public @interface GPController {

    String value() default "";
}
