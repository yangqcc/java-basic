package basic.annotation.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.w3c.dom.Element;

@Retention(RetentionPolicy.RUNTIME) //ע���ע�� ���Ҳ٣���Ԫע��,��ע�Ᵽ�浽�����ڴ�׶�
@Target({ElementType.METHOD,ElementType.TYPE}) //ע��������ĸ�λ��
public @interface MyAnnotion {
	String color() default "blue";
	String value(); //��������
	int[] arrayAttr() default {1,2,3};
	MetaAnnotion annotationAttr() default @MetaAnnotion("hello");
	Class a();
}
