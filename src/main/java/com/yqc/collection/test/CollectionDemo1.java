package com.yqc.collection.test;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 容器类型
 * 数组和StringBuffer(结果是字符串，不一定满足要求)
 *
 * 针对不同需求，java提供了不同集合类
 * 2015.10.8
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		//测试不带All的方法
		Collection c=new ArrayList();
		System.out.println("c:"+c);
		//测试带All的方法
		Collection c1=new ArrayList();
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");
		c1.add("abc5");
		c1.add("abc6");
		Collection c2=new ArrayList();
		c2.add("abc4");
		c2.add("abc6");
		c2.add("abc7");

		//removeAll只要有一个元素移除了就返回All
		//containsAll只有全部包含所有元素才叫包含
		//retainAll如果有交集则返回true,如果没有交集则返回false
//		System.out.println("removeAll:"+c1.removeAll(c2));
//		System.out.println("c1:"+c1);
//		System.out.println("c2:"+c2);
//		System.out.println("addAll:"+c1.addAll(c2));

		//假如有两个集合A，B
		//A对B交集，最终保存在A中，B不变
		//返回值表示A是否发生变化
		System.out.println("c1:"+c1);
		//获取交集
		System.out.println("retainAll:"+c1.retainAll(c2));
		System.out.println("c1:"+c1);
	}
}
