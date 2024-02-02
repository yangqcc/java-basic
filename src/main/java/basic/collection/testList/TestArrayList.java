package basic.collection.testList;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("hello");
    list.add("hello2");
    list.add("hello3");
    list.add("hello4");
    System.out.println(list.get(0));

    //subList，修改视图可以影响原数组，不会报错，如果修改了原数组，可能就会影响到视图，
    //所以修改了原数组，即使从视图获取元素，也会报错
    List<String> strings = list.subList(0, 3);
    System.out.println(strings);
    strings.add("hello5");
    strings.add("hello5");
    list.add(1, "hello6");//修改了原数组，再修改视图，就会报错
    System.out.println(list);
    System.out.println(strings.get(1));//如果发现原数组修改过，视图查询要报错

  }

}
