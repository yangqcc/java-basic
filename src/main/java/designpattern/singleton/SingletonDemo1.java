package designpattern.singleton;

/**
 * 使用内部类的好处是，静态内部类不会在单例加载时就加载，而是在调用getInstance()方法时才进行加载 ，
 * 达到了类似懒汉模式的效果，而这种方法又是线程安全的。
 * 2018/3/19
 *
 * @author yangqc
 */
public class SingletonDemo1 {

    private SingletonDemo1() {
    }

    private static class SingletonHolder {

        private static SingletonDemo1 singletonDemo = new SingletonDemo1();
    }

    public SingletonDemo1 getInstance() {
        return SingletonHolder.singletonDemo;
    }
}
