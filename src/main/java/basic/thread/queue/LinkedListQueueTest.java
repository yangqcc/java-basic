package basic.thread.queue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-05-06
 * @modified By yangqc
 */
public class LinkedListQueueTest {

    public static void main(String[] args) {
        LinkedBlockingDeque<User> linkedBlockingDeque = new LinkedBlockingDeque<>(2);
        linkedBlockingDeque.add(new User("qicheng", 12));
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
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
