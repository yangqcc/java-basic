package basic.math.systemtest;

/**
 * system���ܱ�ʵ����,���Ǿ�̬����
 *
 * ����: public static void gc() ���������� public static void exit(int status) public static long
 * currentTimeMillis
 *
 * @author yangqc
 */
public class SystemDemo {

  public static void main(String[] args) {
    Person p = new Person("�ڳ�", 60);
    System.out.println(p);
    p = null;
    System.gc();
  }
}
