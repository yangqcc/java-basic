/*
 * ��Exception������һ������
 * fillInStackTrace����
 * 2015.2.11
 */
package basic.exception;

public class Rethrowing {

  public static void f() throws Exception {
    System.out.println("originating the exception in f()");
    throw new Exception("throw from f()");
  }

  public static void g() throws Exception {
    try {
      f();
    } catch (Exception e) {
      System.out.println("Inside() g(),e.printStackTrace()");
      e.printStackTrace(System.out);
      throw e;
    }
  }

  public static void h() throws Exception {
    try {
      f();
    } catch (Exception e) {
      System.out.println("Insede h(),e.printStackTrace()");
      e.printStackTrace(System.out);
      throw (Exception) e.fillInStackTrace();//fillInStackTrace() �õ�ǰջ����Ϣ����쳣����Ϣ
    }
  }

  public static void main(String[] args) {
    try {
      g();
    } catch (Exception e) {
      System.out.println("main:printStackTrace()");
      e.printStackTrace(System.out);
    }
    try {
      h();
    } catch (Exception e) {
      System.out.println("main:printStackTrace()");//�쳣λ�õĸı�
      e.printStackTrace(System.out);
    }
  }
}
