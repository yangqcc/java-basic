package designpattern.singleton;

/**
 * 饱汉模式
 * 2018/3/19
 */
public class Singleton2 {

    private static final Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public Singleton2 getInstance() {
        return instance;
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolve() {
        return getInstance();
    }
}
