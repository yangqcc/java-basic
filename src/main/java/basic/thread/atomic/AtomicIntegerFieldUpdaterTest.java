package basic.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * <p>title:对象的属性修改类型原子类</p>
 * <p>description:
 * 如果需要原子更新某个类里的某个字段时，需要用到对象的属性修改类型原子类。
 * <p>
 * AtomicIntegerFieldUpdater:原子更新整形字段的更新器 AtomicLongFieldUpdater：原子更新长整形字段的更新器
 * AtomicStampedReference ：原子更新带有版本号的引用类型。该类将整数值与引用关联起来，可用于解决原子的更新数据和数据的版本号， 可以解决使用 CAS
 * 进行原子更新时可能出现的ABA 问题。
 * <p>
 * 要想原子地更新对象的属性需要两步。
 * <p>
 * 第一步，因为对象的属性修改类型原子类都是抽象类，所以每次使用都必须使用静态方法 newUpdater()创建一个更新器， 并且需要设置想要更新的类和属性。 第二步，更新的对象属性必须使用
 * public volatile 修饰符。
 * <p>
 * 上面三个类提供的方法几乎相同，所以我们这里以 AtomicIntegerFieldUpdater为例子来介绍。
 * </p>
 *
 * @author yangqc
 * @date Created in 2019-04-12
 * @modified By yangqc
 */
public class AtomicIntegerFieldUpdaterTest {

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

        User user = new User("Java", 22);
        // 22
        System.out.println(a.getAndIncrement(user));
        // 23
        System.out.println(a.get(user));
    }
}

class User {

    private String name;
    /**
     * 必须使用volatile修饰，为了保证可见性
     */
    public volatile int age;

    public User(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
