package thinkinjava.test13.proxy;

public class SimpleProxyDemo {

  public static void consumer(Interface iface) {
    iface.doSomething();
    iface.somethingElse("����");
  }

  public static void main(String[] args) {
    consumer(new RealObject());
    consumer(new SimpleProxy(new RealObject()));
  }
}
