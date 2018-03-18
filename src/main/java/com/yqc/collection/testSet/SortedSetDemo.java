package com.yqc.collection.testSet;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 测试TreeSet，TreeSet内部是以Comparable来排序的，TreeSet是有序的，LinkedHashSet内部也是有序的
 *
 * @author Administrator
 */
public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(sortedSet, "one two three four five six seven eigh".split(" "));
        System.out.println(sortedSet);
        String low = sortedSet.first();
        String high = sortedSet.last();
        System.out.println(low);
        System.out.println(high);
        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) {
                low = it.next();
            }
            if (i == 6) {
                high = it.next();
            } else {
                it.next();
            }
        }
        System.out.println(low);
        System.out.println(high);
        System.out.println(sortedSet.subSet(low, high));
        System.out.println(sortedSet.headSet(high));
        System.out.println(sortedSet.tailSet(low));
    }
}
