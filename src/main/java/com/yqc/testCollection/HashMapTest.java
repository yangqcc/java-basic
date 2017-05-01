package com.yqc.testCollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HashMap的四种遍历方式
 * 
 * 其实第二种和第三种是一种方式,因为forEach就是一种语法糖
 * 
 * @author yangqc
 *
 */
public class HashMapTest {
	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			hashMap.put(i, new Integer(i).toString());
		}

		/**
		 * 第一种遍历方法
		 */
		System.out.println("通过Map.keySet遍历key和value");
		for (Integer key : hashMap.keySet()) {
			System.out.println("key: " + key + " , value: " + hashMap.get(key));
		}

		// Iterator<Integer> it = hashMap.keySet().iterator();
		// while (it.hasNext()) {
		// System.out.println(it.next());
		// }

		System.out.println("通过Map.entrySet使用iterator遍历key和value");
		Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> entry = iterator.next();
			System.out.println("key: " + entry.getKey() + " , value: " + entry.getValue());
		}

		System.out.println("通过Map.entrySet遍历key和value");
		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			System.out.println("key: " + entry.getKey() + " , value: " + entry.getValue());
		}

		System.out.println("通过Map.values()遍历所有的value,但不能遍历key");
		for (String value : hashMap.values()) {
			System.out.println(value);
		}
	}
}
