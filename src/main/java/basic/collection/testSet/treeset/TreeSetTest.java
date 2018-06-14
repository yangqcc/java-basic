package basic.collection.testSet.treeset;

import java.util.TreeSet;

/**
 * 测试TreeSet
 *
 * @author yangqc
 */
public class TreeSetTest {

    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet();
        treeSet.add(new Person("启程", 2));
        treeSet.add(new Person("优啦", 3));
        treeSet.add(new Person("试驾", 1));
        for (Person person : treeSet) {
            System.out.println(person);
        }
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        //年龄是比较的主要条件
        int num = this.age - o.age;
        //姓名是比较的次要条件
        return num == 0 ? this.name.compareTo(o.name) : num;
    }
}
