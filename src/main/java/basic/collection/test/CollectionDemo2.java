package basic.collection.test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Object[] toArray   2015.10.8
 *
 * @author yangqc
 */
public class CollectionDemo2 {

  public static void main(String[] args) {
    Collection<String> c = new ArrayList<>();
    c.add("hello");
    c.add("world");
    c.add("java");
    Object[] objs = c.toArray();
    for (int x = 0; x < objs.length; x++) {
      System.out.println(objs[x]);
      String s = (String) objs[x];
      System.out.println(s + "-----" + s.length());
    }
  }
}
