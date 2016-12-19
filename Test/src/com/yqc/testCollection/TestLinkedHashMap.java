package com.yqc.testCollection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap按访问顺序排序
 * 
 * @author yangqc 2016年12月19日
 */

public class TestLinkedHashMap {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>(10, .075f, true);
		for (int i = 0; i < 10; i++) {
			map.put(i, new Integer(i).toString());
		}
		map.get(2);
		map.get(3);
		map.get(4);
		map.get(5);
		Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getValue());
		}

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " * " + entry.getValue());
		}

	}
}
