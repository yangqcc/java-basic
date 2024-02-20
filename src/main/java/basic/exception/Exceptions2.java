package basic.exception;

class SecondException extends Exception {

  public SecondException() {
  }

  ;

  public SecondException(String msg) {
    super(msg);
  }
}

public class Exceptions2 {

  public static void f(int i) throws SecondException {
    if (i == 1) {
      System.out.println("this is one!");
    } else {
      throw new SecondException();
    }
  }

  public static void g(String a) throws SecondException {
    if (a.equals("hello")) {
      System.out.println("this is hello");
    } else {
      throw new SecondException("������!");
    }
  }

  public static void main(String[] args) {
    try {
      f(2);
    } catch (SecondException e) {
      e.printStackTrace(System.err);
    } finally {
      System.out.println("this is finally!");
    }
    try {
      g("HELLO");
    } catch (SecondException e) {
      e.printStackTrace(System.err);
    }
  }
}
