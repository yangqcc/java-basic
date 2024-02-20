package basic.annotation.test;

/**
 * 反射获取注解
 *
 * @author yangqc
 */
public class ReflectMyAnnotation {

  public static void main(String[] args) {
    if (TestMyAnnotation.class.isAnnotationPresent(MyAnnotation.class)) {
      MyAnnotation annotation = TestMyAnnotation.class.getAnnotation(MyAnnotation.class);
      System.out.println(annotation.color());
      System.out.println(annotation.value());
      System.out.println(annotation.arrayAttr().length);
//			MyAnnotation annotation=annotation.annotationAttr();
      System.out.println(annotation.annotationAttr().value());
    }
  }
}
