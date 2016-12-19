package com.yqc.testCollection.comparable;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * LRU缓存初步实现
 * @author yangqc
 * 2016年12月19日
 * @param <K>
 * @param <V>
 */
public class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = 1L;

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		if (keySet().size() > 10) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MyLinkedHashMap<Integer, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
		for (int i = 0; i < 20; i++) {
			myLinkedHashMap.put(i, i);
		}
		for (Map.Entry<Integer, Integer> entry : myLinkedHashMap.entrySet()) {
			System.out.println(entry.getKey() + " , " + entry.getValue());
		}
	}
}
