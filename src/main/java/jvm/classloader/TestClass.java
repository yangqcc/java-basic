package jvm.classloader;

public class TestClass {

  public static void main(String[] args) {
    System.out.println("hello");
  }

  private final String str = "hello";

  void printInt() {
    System.out.println(65535);
  }
}
