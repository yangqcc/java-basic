package basic.thread.volatiletest;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-05-06
 * @modified By yangqc
 */
public class SwapDemo {

    public static void main(String[] args) {
        Integer a = 1, b = 2;
        System.out.println("before:a=" + a + ",b=" + b);
        swap(a, b);
        System.out.println("after:a=" + a + ",b=" + b);
    }

    public static void swap(Integer i1, Integer i2) {
        Integer i3 = i2 + i1;
        System.out.println(i3);
        i2 = i3 - i2;
        System.out.println(i2);
        i1 = i3 - i2;
        System.out.println(i1);
    }
}
