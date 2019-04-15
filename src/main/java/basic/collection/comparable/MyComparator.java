package basic.collection.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 比较器
 *
 * @author yangqc
 */
public class MyComparator implements Comparator<Apple> {

  @Override
  public int compare(Apple apple1, Apple apple2) {
    if (apple1.getCount() < apple2.getCount()) {
      return -1;
    } else if (apple1.getCount() > apple2.getCount()) {
      return 1;
    }
    return 0;
  }

  public static void main(String[] args) {
    Apple apple1 = new Apple(1);
    Apple apple2 = new Apple(2);
    MyComparator myComparator = new MyComparator();
    System.out.println(myComparator.compare(apple1, apple2));
    List<Apple> appleList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      appleList.add(new Apple(10 - i));
    }
    Collections.sort(appleList, myComparator);
    System.out.println(Arrays.toString(appleList.toArray()));
  }

}
