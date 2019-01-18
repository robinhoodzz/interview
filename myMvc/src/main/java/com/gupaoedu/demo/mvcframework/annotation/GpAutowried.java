package com.gupaoedu.demo.mvcframework.annotation;

import java.lang.annotation.*;

/**
 * Created by robin on 19/1/18.
 */
@Target({ElementType.FIELD}) // 属性上
@Retention(RetentionPolicy.RUNTIME)// 运行时阶段可用
@Documented
public @interface GpAutowried {

    String value() default "";
}
