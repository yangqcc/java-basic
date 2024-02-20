package thinkinjava.test13.proxy;

public class RealObject implements Interface {

  public void doSomething() {
    System.out.println("doSomething");
  }

  public void somethingElse(String args) {
    System.out.println("somethingElse" + args);
  }
}
