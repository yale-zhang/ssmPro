package com.yale.ssm.validator.annotation;

import com.yale.ssm.validator.ListNotHasNullValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义参数校验注解
 *  校验List集合中是否null元素
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ListNotHasNullValidatorImpl.class)////此处指定了注解的实现类为ListNotHasNullValidatorImpl
public @interface ListNotHasNull {
    /**
     * 添加value属性,可以作为校验时的条件，非必需
     */
    int value() default 0;

    String message() default "List集合中不能含有null元素";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 定义List，为了让Bean的一个属性上可以添加多套规则
     */
     @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
     @Retention(RUNTIME)
     @Documented
     @interface List{
        ListNotHasNull[] value();
    }

}
