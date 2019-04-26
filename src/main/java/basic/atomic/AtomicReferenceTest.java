package basic.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-04-12
 * @modified By yangqc
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        AtomicReference<Person> atomicReference = new AtomicReference<>();
        Person person = new Person("Nicholas", 123);
        atomicReference.set(person);
        Person updatePerson = new Person("Daisy", 20);
        atomicReference.compareAndSet(person, updatePerson);
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getAge());
    }
}

class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
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
