package designpattern.singleton;

/**
 * @author yangqc
 */
public class Singleton1 {

    /**
     * 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载
     */
    private static Singleton1 instance = null;

    /**
     * 私有构造方法，防止被实例化
     */
    private Singleton1() {
    }

    /**
     * 静态工程方法，创建实例,该方法为同步方法,为了避免多线程 请求时出现问题,但是效率比较低,初始化只有一次,初始化完成后 大部分请求时,instance已经被赋值
     */
    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

    /**
     * getInstance改进版
     */
    public static Singleton1 getInstance2() {
        if (instance == null) {
            synchronized (Singleton1.class) {
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolve() {
        return instance;
    }
}
