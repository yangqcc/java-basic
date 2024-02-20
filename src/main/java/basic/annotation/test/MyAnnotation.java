package basic.annotation.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //注解使用时间点
@Target({ElementType.METHOD, ElementType.TYPE}) //注解使用位置
public @interface MyAnnotation {

  String color() default "blue";

  String value(); //值

  int[] arrayAttr() default {1, 2, 3};

  MetaAnnotation annotationAttr() default @MetaAnnotation("hello");

  Class a();
}
