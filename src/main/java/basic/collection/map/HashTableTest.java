package basic.collection.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>title:</p>
 * <p>description:
 * Hashtable和HashMap的区别
 * Hashtable不同于HashMap，前者既不允许key为null，也不允许value为null;
 * <p>
 * HashMap中用于定位桶位的Key的hash的计算过程要比Hashtable复杂一点，没有Hashtable如此简单、直接；
 * <p>
 * 在HashMap的插入K/V对的过程中，总是先插入后检查是否需要扩容；而Hashtable则是先检查是否需要扩容后插入；
 * <p>
 * Hashtable不同于HashMap，前者的put操作是线程安全的。
 * </p>
 *
 * @author yangqc
 * @date Created in 2019-05-13
 * @modified By yangqc
 */
public class HashTableTest {

    public static void main(String[] args) {
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        hashTable.put(1, 2);

        TreeMap<TestNoCompare, Integer> treeMap = new TreeMap<>();
        /**
         * treeMap的键要么实现Comparable接口，要么传入一个Comparator
         */
        treeMap.put(new TestNoCompare("12"), 2);
        Set<Map.Entry<TestNoCompare, Integer>> entries = treeMap.entrySet();
        Iterator<Map.Entry<TestNoCompare, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        /**
         * 第三个参数是顺序，true是获取顺序，false是插入顺序
         * LinkedHashMap可以用来做LRU算法实现
         */
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>(12, 0.75f, true);
        linkedHashMap.put(12, 21);
        linkedHashMap.get(12);

        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>(12);
        concurrentHashMap.put(1, 2);
        System.out.println(concurrentHashMap.get(1));
    }
}

class TestNoCompare implements Comparable<TestNoCompare> {
    private String name;

    public TestNoCompare(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(TestNoCompare o) {
        return 0;
    }
}
