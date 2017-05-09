package com.yqc.collection.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
 * 迭代器依赖于介个而存在，在判断成功后，集合中新添加了元素，而迭代器却不知道
 * 错误叫并发修改异常
 *   即迭代器遍历元素的时候，集合是不能修改元素的
 * 
 * 如何解决?
 *   A:迭代器迭代元素，迭代器修改元素
 *       使用listIterator,但是修改的元素是跟在刚才元素后面的
 *   B:集合遍历元素，集合修改元素 
 *       元素加在最后面
 * 2015.10.9
 */
import java.util.ListIterator;

public class ListDemo2 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		List<String> list1=null;
		
		list.add("hello");
		list.add("world");
		list.add("java");
		//注意这里判断不能交换顺序
//		if(list1!=null && list1.iterator().hasNext()){
//		   System.out.println(list1.iterator().next());
//		}else{
//			System.out.println("no!");
//		}
//		Iterator it=list.iterator();
//		while(it.hasNext()){
//			String s=(String) it.next();
//			if("world".equals(s)){
//				list.add("javaee");
//			}
//			System.out.println("list:"+list);
//		}
		
		ListIterator lit=list.listIterator();
		while(lit.hasNext()){
			String s=(String) lit.next();
			if("world".endsWith(s)){
				lit.add("javaee");
			}
		}
		
		for(int i=0;i<list.size();i++){
			String s=list.get(i);
			if("world".equals(s)){
				list.add("javaee");
			}
		}
		System.out.println("list:"+list);
	}
}
