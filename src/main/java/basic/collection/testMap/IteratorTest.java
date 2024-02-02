package basic.collection.testMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorTest {

  public static void main(String[] args) {
    test();
    ArrayList<Integer> al = new ArrayList<>();
    al.add(1);
    al.add(2);
    Iterator<Integer> iterator = al.iterator();
    while (iterator.hasNext()) {
      iterator.remove();
      iterator.remove();//会报错
    }
  }

  public static void test() {
    List<String> cawList = new CopyOnWriteArrayList<>();
    cawList.add("1");
    cawList.add("2");
    cawList.add("3");
    Iterator<String> iterator = cawList.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      iterator.remove();
    }
  }

  public static void test2() {
    CopyOnWriteArrayList<String> userNames = new CopyOnWriteArrayList<String>() {{
      add("Hollis");
      add("hollis");
      add("HollisChuang");
      add("H");
    }};

    Iterator<String> it = userNames.iterator();

    for (String userName : userNames) {
      if (userName.equals("Hollis")) {
        userNames.remove(userName);
      }
    }

    System.out.println(userNames);

    while(it.hasNext()){
      System.out.println(it.next());
    }
  }

}
