package basic.annotation.test;
/**
 * ����Ƿ���ע��
 * @author Administrator
 *
 */
public class ReflectMyAnnotion {
	public static void main(String[] args) {
		if(TestMyAonnotion.class.isAnnotationPresent(MyAnnotion.class)){
			MyAnnotion annotion=TestMyAonnotion.class.getAnnotation(MyAnnotion.class);
			System.out.println(annotion.color());
			System.out.println(annotion.value());
			System.out.println(annotion.arrayAttr().length);
//			MyAnnotion annotion=annotion.annotationAttr();
			System.out.println(annotion.annotationAttr().value());
		}
	}
}
