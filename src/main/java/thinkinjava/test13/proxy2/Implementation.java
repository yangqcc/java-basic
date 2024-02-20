package thinkinjava.test13.proxy2;

public class Implementation implements SomeMethods {

  @Override
  public void boring1() {
    System.out.println("borging1");
  }

  @Override
  public void boring2() {
    System.out.println("bording2");
  }

  @Override
  public void interesting(String arg) {
    System.out.println("interesting " + arg);
  }

  @Override
  public void boring3() {
    System.out.println("bording3");
  }

}
