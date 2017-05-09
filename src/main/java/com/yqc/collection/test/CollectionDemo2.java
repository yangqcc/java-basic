package com.yqc.collection.test;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 集合的遍历
 *   依次获取集合的元素
 * Object[] toArray  把集合转成数组，可实现集合遍历
 * 2015.10.8
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add("hello");
		c.add("world");
		c.add("java");
		Object[] objs=c.toArray();
		for(int x=0;x<objs.length;x++){
//			System.out.println(objs[x]);
			//知道元素是字符串，获取元素的同时，还想知道元素的长度
			//要想使用字符串的方法，就必须把元素还原成字符串
			String s=(String)objs[x];
			System.out.println(s+"-----"+s.length());
		}
	}
}
