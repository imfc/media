package com.imfc.media.company.annoation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnyAccess {
    /**
     * 是否登录成功才能通过
     * <p>Defaults to {@code true}.
     */
    boolean required() default true;
}
