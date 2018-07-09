如何优雅的对参数进行校验呢？
    JSR303，Hibernate Validator
    JSR303就是为了解决这个问题出现的，JSR303，Hibernate Validator 等校验工具的使用，以及自定义校验注解的使用。
    JSR303 是一套JavaBean参数校验的标准，它定义了很多常用的校验注解，我们可以直接将这些注解加在我们JavaBean的属性上面，
    就可以在需要校验的时候进行校验了。注解如下：
       Bean Validator内置的注解
       @AssertFalse     Boolean, boolean    判断关联属性是否为布尔值false
       @AssertTrue      Boolean, boolean    Checks that the annotated element istrue.
       @DecimalMax      BigDecimal, BigInteger, String, byte, short, int,long and the respective wrappers of the primitive types. Additionally supported by HV: any sub-type of Number.
       被注解的值必须不大于约束中指定的最大值. 这个约束的参数是一个通过BigDecimal定义的最大值的字符串表示.
       @DecimalMin      BigDecimal, BigInteger, String, byte, short, int,long and the respective wrappers of the primitive types. Additionally supported by HV: any sub-type of Number.
       被注解的值必须不小于约束中指定的最小值. 这个约束的参数是一个通过BigDecimal定义的最小值的字符串表示.
       @Digits(integer=, fraction=)     BigDecimal, BigInteger, String, byte, short, int,long and the respective wrappers of the primitive types. Additionally supported by HV: any sub-type of Number.
       校验整数位数和小数位数
       对应的数据库表字段会被设置精度(precision)和准度(scale).
       @Future
       java.util.Date, java.util.Calendar; Additionally supported by HV, if the Joda Time date/time API is on the class path: any implementations of ReadablePartial and ReadableInstant.
       检查给定的日期是否比现在晚.
       @Max
       BigDecimal, BigInteger, byte, short, int, longand the respective wrappers of the primitive types. Additionally supported by HV: String(the numeric value represented by a String is evaluated), any sub-type of Number.
       检查该值是否小于或等于约束条件中指定的最大值.
       会给对应的数据库表字段添加一个check的约束条件.
       @Min
       BigDecimal, BigInteger, byte, short, int, longand the respective wrappers of the primitive types. Additionally supported by HV: String(the numeric value represented by a String is evaluated), any sub-type of Number.
       检查该值是否大于或等于约束条件中规定的最小值.
       会给对应的数据库表字段添加一个check的约束条件.
       @NotNull     Any type
       Checks that the annotated value is notnull.
       对应的表字段不允许为null.
       @Null    Any type
       Checks that the annotated value is null.
       @Past
       java.util.Date, java.util.Calendar; Additionally supported by HV, if the Joda Time date/time API is on the class path: any implementations of ReadablePartial and ReadableInstant.
       检查注解对象中的值表示的日期比当前早.
       @Pattern(regex=, flag=)
       String 检查该字符串是否能够在match指定的情况下被regex定义的正则表达式匹配.
       @Size(min=, max=)
       String, Collection, Map and arrays
       校验对象的size。本文作者认为前提是该对象有size()方法，String除外。
       对应的数据库表字段的长度会被设置成约束中定义的最大值.
       @Valid
       Any non-primitive type
       Hibernate Validator拓展的注解：
        @CreditCardNumber   String  校验信用卡号码
        @Email              String  校验邮件地址
        @Length(min=, max=) String  功能同@Size，但是只支持String类型
        对应的数据库表字段的长度会被设置成约束中定义的最大值.
        @NotBlank           String  不为null，不为空值，不为全空格。功能强大于@NotEmpty
        @NotEmpty           String,Collection,Map and arrays    校验是否为null或者为空值。功能强于@NotNull
        @Range(min=, max=)  BigDecimal,BigInteger,String, byte,short, int,long and the respective wrappers of the primitive types
        判断数值的范围，不仅支持数值类型，还支持字符串、字节等等类型
        @SafeHtml(whitelistType=, additionalTags=)
        CharSequence 无使用价值
        @ScriptAssert(lang=, script=, alias=)
        Any type  无使用价值
        @URL(protocol=, host=, port=, regexp=, flags=)
        String
        Validator框架拓展注解
        @NotEmptyPattern    String          在字符串不为空的情况下，验证是否匹配正则表达式
        @ListStringPattern  List<String>    验证集合中的字符串是否满足正则表达式
        @DateValidator      String          验证日期格式是否满足正则表达式，Local为ENGLISH
        @DateFormatCheckPattern String      验证日期格式是否满足正则表达式，Local为自己手动指定
    Spring validtor 同样扩展了jsr303,并实现了方法参数和返回值的校验
    Spring 提供了MethodValidationPostProcessor类，用于对方法的校验
    Validator提供两种工作模式：
        1、普通模式
        2、快速失败返回模式
    默认的工作模式为快速失败返回模式，一旦发现校验失败项，立即返回。普通模式在测试时期可以使用，
    可以对全部的校验项进行完整的校验（校验组序列，以及基于校验组序列的其他配置无效），通过修改配置文件中的校验模式，
    从而实现工作模式的自由切换。
    工作模式配置如下：
    validator.fail_fast:快速失败返回模式(只要有一个验证失败，则返回异常)
    validator.normal:普通模式(会校验完所有的属性，然后返回所有的验证失败信息)
    Validator校验框架按照Bean Validation的规范，使用了Hibernate Validatior框架。
        1、内置注解校验
        2、对象图级联校验
        3、校验组分组校验
        4、校验组序列
        5、自定义默认校验组功能
        6、自定义智能默认校验组功能
        7、自定义校验注解
        8、类校验——类属性的关联校验
    Validator的配置文件
        <bean id="baseValidator" class="com.chhliu.common.validator.BaseValidator">  
            <property name="validatorMode">  
                <!-- 校验器的工作模式:  
                validator.fail_fast:快速失败返回模式(只要有一个验证失败，则返回异常)  
                validator.normal:普通模式(会校验完所有的属性，然后返回所有的验证失败信息)  
                -->  
                <value>validator.normal</value>  
            </property>  
        </bean>
    Validator中的方法
    1、<T> void validate(T object) throws Exception 用途：校验一个对象的默认校验组的属性。
    2、<T> void validate(T object, Class<?>... groups) throws Exception      用途：校验一个对象的指定的一个或多个校验组的属性。
    3、<T> void validateProperty(T object, String propertyName) throws Exception     用途：校验一个对象的默认校验组的一个指定的属性值。
    4、<T> void validateProperty(T object, String propertyName, Class<?>... groups) throws Exception     用途：校验一个对象指定校验组中的一个指定的属性值。
    5、<T> void validateValue(Class<T> beanType, String propertyName, Object value) throws Exception     用途：校验一个value是否符合指定类的默认校验组下的某一个属性值。
    6、<T> void validateValue(Class<T> beanType, String propertyName, Object value, Class<?>... groups) throws Exception     用途：校验一个value是否符合指定类的指定校验组下的某一个属性值。
    自定义校验注解
        “List数组中不能含有null元素”为实例自定义校验注解
    Spring validator 方法级别的校验
        JSR和Hibernate validator的校验只能对Object的属性进行校验，不能对单个的参数进行校验，spring 在此基础上进行了扩展，
        添加了MethodValidationPostProcessor拦截器，可以实现对方法参数的校验.
        1、实例化MethodValidationPostProcessor
        @Bean
            public MethodValidationPostProcessor methodValidationPostProcessor() {
                return new MethodValidationPostProcessor();
            }
        2、在所要实现方法参数校验的类上面添加@Validated，如下
        @RestController
        @Validated
        public class ValidateController {
        }
        3、在方法上面添加校验规则:
          @RequestMapping(value = "/test", method = RequestMethod.GET)
            public String paramCheck(@Length(min = 10) @RequestParam String name) {
                System.out.println(name);
                return null;
            }
        当方法上面的参数校验失败,spring 框架就回抛出异常
        {
          "timestamp": 1476108200558,
          "status": 500,
          "error": "Internal Server Error",
          "exception": "javax.validation.ConstraintViolationException",
          "message": "No message available",
          "path": "/test"
        }
        从此可以优雅的对参数进行校验了 
        只列举了常用的几种校验方法，其实关于校验的内容还有很多:
            校验信息的国际化显示，
            组合参数校验，
            message中使用EL表达式，
            将校验信息绑定到ModelAndView
            将校验信息绑定到ModelAndView    http://www.voidcn.com/blog/983836259/article/p-5794496.html
            集成Bean Validation 1.1(JSR-349)到SpringMVC   https://my.oschina.net/qjx1208/blog/200946