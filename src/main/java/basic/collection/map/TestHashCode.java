package basic.collection.map;

import java.util.HashMap;

public class TestHashCode {
    public static void main(String[] args) {
        Animal animal1 = new Animal(123);
        Animal animal2 = new Animal(123);
        System.out.println(animal1.equals(animal2));
        HashMap<String, Animal> map = new HashMap<String, Animal>();
        map.put("123", animal1);
        animal1.setAge(2);
        System.out.println(map.get("123"));
    }
}

class Animal {
    private int age;

    Animal(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Animal)) {
            return false;
        }
        return ((Animal) obj).getAge() == this.getAge();
    }

    @Override
    public int hashCode() {
        return age;
    }

    @Override
    public String toString() {
        return "this age is: " + age;
    }
}