package basic.collection.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator iterator 迭代器遍历
 * <p>
 * E next() 可能会抛出 NoSuchElementException;异常
 * <p>
 * boolean hasNext() 判断是否还有下一个元素
 *
 * @author yangqc 2015.10.8
 */
public class CollectionIterator {

  public static void main(String[] args) {
    Collection<String> c = new ArrayList<>();
    c.add("hello");
    c.add("world");
    c.add("java");
    //Iterator iterator
    //迭代器遍历
    Iterator it = c.iterator();
    //迭代器遍历
    while (it.hasNext()) {
      //
      System.out.println(it.next());
    }

  }
}
