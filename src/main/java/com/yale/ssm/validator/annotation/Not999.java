package com.yale.ssm.validator.annotation;

import com.yale.ssm.validator.Not999Validator;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 自定义validator标签(和hibernate validator组合使用)
 *
 */
@Constraint(validatedBy = Not999Validator.class)//具体实现
public @interface Not999 {
    //提示信息 可以写死 可填写国际化key
    String message() default "{com.yale.ssm.validator.annotation.Not999}";

    //下面这2个属性必须添加
    Class<?>[] group() default {};

    Class<? extends Payload>[] payload() default {};
}
