package basic.collection.testSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LinedHashSet按顺序存储,因为LinkedHashSet内部是LinkedHashMap 而HashSet内部就是HashMap
 *
 * @author yangqc 2016年12月19日
 */
public class TestLinkedHashSet {

  public static void main(String[] args) {
    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    //顺序是新增的顺序，每个节点有个before,和after字段，新增的时候添加到链表末尾，保证了顺序
    for (int i = 0; i < 10; i++) {
      set.add(10 - i);
    }
    Iterator<Integer> iterator = set.iterator();
    while (iterator.hasNext()){
      System.out.println(iterator.next());
    }
    System.out.println("下面是HashSet");
    Set<Integer> set2 = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      set2.add(10 - i);
    }
    for (Integer i : set2) {
      System.out.print(i + ",");
    }
  }
}
