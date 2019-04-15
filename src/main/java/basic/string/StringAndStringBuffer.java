package basic.string;

/**
 * @author yangqc
 */
public class StringAndStringBuffer {

  public static void main(String[] args) {
    //String 底层是private　final　char　value[]，由于是final修饰的，所以是不可变的
    //当然也是线程安全的
    String s = "hello";
    //StringBuffer sb=s;
    /**
     * StringBuffer继承自 AbstractStringBuilder
     * abstract class AbstractStringBuilder implements Appendable, CharSequence{
     *   char[] value;
     *     int count;
     *     private static final int MAX_ARRAY_SIZE = 2147483639;
     *
     *     AbstractStringBuilder() {
     *     }
     *
     *     AbstractStringBuilder(int var1) {
     *         this.value = new char[var1];
     *     }
     *   .....
     * }
     * 可以看出AbstractStringBuilder里面保存的是char[] value，所以是可变的
     *
     * 但是StringBuffer加了synchronized同步，所以是线程安全的，
     * 而是StringBuilder没有加同步锁，所以是线程不安全的。
     */
    StringBuffer sb = new StringBuffer(s);
    StringBuffer sb2 = new StringBuffer();
    sb2.append(s);

    System.out.println("sb:" + sb);
    System.out.println("sb2:" + sb2);
    StringBuffer buffer = new StringBuffer("java");
    //String(StringBuffer buffer)
    //1.StringBuffer转String
    String str = new String(buffer);
    //2.StringBuffer的toString方法转成String类型
    //其实buffer的toString方法内部就是调用了new String()方法
    String str2 = buffer.toString();
    System.out.println("str:" + str);
    System.out.println("str2:" + str2);
  }
}
