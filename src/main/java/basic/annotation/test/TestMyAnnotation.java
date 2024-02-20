package basic.annotation.test;

/**
 * 使用注解
 *
 * @author Yangqc 2015.10.19
 */
@MyAnnotation(value = "abc", arrayAttr = {1,
    1}, annotationAttr = @MetaAnnotation("bob"), a = String.class)
public class TestMyAnnotation {

}
