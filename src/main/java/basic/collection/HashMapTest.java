package basic.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HashMap学习
 * HashMap允许有null的值和null的key
 * HashMap基本和HashTable一样，除了HashMap是线程不安全的，已经允许有null的key
 * H
 *
 * @author yangqc
 */
public class HashMapTest {

    public static void main(String[] args) {
        //HashMap初始化的时候最好指定默认值，避免扩容的时候消耗时间
        //一般为2的n次方
        HashMap<Integer, String> hashMap = new HashMap<>(16);
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, Integer.toString(i));
        }

        /**
         * HashMap通过keySet获取所有的key的set
         */
        for (Integer key : hashMap.keySet()) {
            System.out.println("key: " + key + " , value: " + hashMap.get(key));
        }

        // Iterator<Integer> it = hashMap.keySet().iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }

        //HashMap推荐遍历方式
        Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("key: " + entry.getKey() + " , value: " + entry.getValue());
        }

        System.out.println("ͨ��Map.entrySet����key��value");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + " , value: " + entry.getValue());
        }

        //HashMap遍历值
        for (String value : hashMap.values()) {
            System.out.println(value);
        }
    }
}
