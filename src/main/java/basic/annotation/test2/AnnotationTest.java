package basic.annotation.test2;

@MyAnnotation(color = "red", value = "adf", arrayAttr = 1)
public class AnnotationTest {

    @MyAnnotation("dfg")
    public static void main(String[] args) {
        if (AnnotationTest.class.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = AnnotationTest.class.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.color());
            System.out.println(annotation.value());
            System.out.println(annotation.arrayAttr().length);
        }
    }
}
