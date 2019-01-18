package com.gupaoedu.demo.mvcframework.annotation;

import java.lang.annotation.*;

/**
 * Created by robin on 19/1/18.
 */
@Target({ElementType.TYPE}) // 类上使用
@Retention(RetentionPolicy.RUNTIME)// 运行时阶段可用
@Documented
public @interface GpService {

    String value() default "";
}
