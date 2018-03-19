package basic.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HashMap�����ֱ�����ʽ
 * <p>
 * ��ʵ�ڶ��ֺ͵�������һ�ַ�ʽ,��ΪforEach����һ���﷨��
 *
 * @author yangqc
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, new Integer(i).toString());
        }

        /**
         * ��һ�ֱ�������
         */
        System.out.println("ͨ��Map.keySet����key��value");
        for (Integer key : hashMap.keySet()) {
            System.out.println("key: " + key + " , value: " + hashMap.get(key));
        }

        // Iterator<Integer> it = hashMap.keySet().iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }

        System.out.println("ͨ��Map.entrySetʹ��iterator����key��value");
        Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("key: " + entry.getKey() + " , value: " + entry.getValue());
        }

        System.out.println("ͨ��Map.entrySet����key��value");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + " , value: " + entry.getValue());
        }

        System.out.println("ͨ��Map.values()�������е�value,�����ܱ���key");
        for (String value : hashMap.values()) {
            System.out.println(value);
        }
    }
}
