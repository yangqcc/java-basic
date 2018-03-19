package basic.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LinedHashSet按顺序存储,因为LinkedHashSet内部是LinkedHashMap
 * 而HashSet内部就是HashMap
 *
 * @author yangqc 2016年12月19日
 */
public class TestLinkedHashSet {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(10 - i);
        }
        for (Integer i : set) {
            System.out.print(i + ",");
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
