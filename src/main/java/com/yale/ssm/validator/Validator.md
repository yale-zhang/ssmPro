如何优雅的对参数进行校验呢？
    JSR303，Hibernate Validator
    JSR303就是为了解决这个问题出现的，JSR303，Hibernate Validator 等校验工具的使用，以及自定义校验注解的使用。
    JSR303 是一套JavaBean参数校验的标准，它定义了很多常用的校验注解，我们可以直接将这些注解加在我们JavaBean的属性上面，
    就可以在需要校验的时候进行校验了。注解如下：
        @Null                   被注释的元素必须为null;
        @NotNull                被注释的元素必须不为null;
        @AssertTrue             被注释的元素必须为true;
        @AssertFalse            被注释的元素必须为false;
        @Min(value)             被注释的元素必须是一个数字，其值必须大于等于指定的最小值
        @Max(value)             被注释的元素必须是一个数字，其值必须大于等于指定的最大值
        @DecimalMin(value)      被注释的元素必须是一个数字，其值必须大于等于指定的最小值
        @DecimalMax(value)      被注释的元素必须是一个数字，其值必须大于等于指定的最大值
        @size(max,min)          被注释的元素大小必须在指定的范围内
        @Digits(integer,fraction)被注释的元素必须在指定的范围内
        @Past                    一个过去的日期
        @Future                  一个将来的日期
        @Pattern(value)          被指定的元素必须符合指定的正则表达式
    Hibernate validator 在JSR303的基础上对校验注解进行了扩展，扩展注解如下：
        @Email      必须是电子邮箱地址
        @Length     字符串大小必须在指定的范围内
        @NotEmpty   必须非空
        @Range      在核实的范围内
    Spring validtor 同样扩展了jsr303,并实现了方法参数和返回值的校验
    Spring 提供了MethodValidationPostProcessor类，用于对方法的校验
    自定义校验注解
        “List数组中不能含有null元素”为实例自定义校验注解