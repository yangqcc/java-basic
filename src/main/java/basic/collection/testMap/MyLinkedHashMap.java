package basic.collection.testMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU�������ʵ��,����10�����������ʹ�õ�
 *
 * @param <K>
 * @param <V>
 * @author yangqc 2016��12��19��
 */
public class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 1L;

    public MyLinkedHashMap() {
        super();
    }

    public MyLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
      return keySet().size() > 10;
    }

    public static void main(String[] args) {
        MyLinkedHashMap<Integer, Integer> myLinkedHashMap = new MyLinkedHashMap<>(10, 0.75f, true);
        for (int i = 0; i < 10; i++) {
            myLinkedHashMap.put(i, i);
        }
        myLinkedHashMap.get(0);
        myLinkedHashMap.get(1);
        myLinkedHashMap.put(11, 11);
        for (Map.Entry<Integer, Integer> entry : myLinkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " , " + entry.getValue());
        }
    }
}
