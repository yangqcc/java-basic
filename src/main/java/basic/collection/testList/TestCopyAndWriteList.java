package basic.collection.testList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyAndWriteList {

  public static void main(String[] args) {
    CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();
    cowList.add("1");
    cowList.add("2");
    cowList.add("3");
    cowList.add("4");
    cowList.add("5");
    Iterator<String> iterator = cowList.iterator();
    while (iterator.hasNext()) {
      cowList.add("66");
      iterator.remove();
      System.out.println(iterator.next());
    }
    System.out.println(cowList);
  }

}
