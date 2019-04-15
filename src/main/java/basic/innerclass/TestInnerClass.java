package basic.innerclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestInnerClass {

  void outerOperateList() {
    List<Integer> list = new ArrayList<>();
    Apple a = new Apple(2);
    list.add(1);
    list.add(2);
    new ListHandler() {
      @Override
      void innerOperateList() {
        list.add(123);
        list.add(321);
        a.set(3);
        System.out.println(a);
        System.out.println(Arrays.toString(list.toArray()));
      }
    }.innerOperateList();
    System.out.println(a);
    System.out.println(Arrays.toString(list.toArray()));
  }

  void changer(Integer a) {
    a = new Integer(11);
  }

  public static void main(String[] args) {
    TestInnerClass testInnerClass = new TestInnerClass();
    testInnerClass.outerOperateList();
    Integer a = new Integer(8);
    testInnerClass.changer(a);
    System.out.println(a);
  }
}

abstract class ListHandler {

  abstract void innerOperateList();
}

class Apple {

  private int a;

  Apple(int a) {
    this.a = a;
  }

  void set(int currentA) {
    a = currentA;
  }

  public String toString() {
    return new Integer(a).toString();
  }
}