package com.yqc.collection.map;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * 内容:程序的不同部分修改容器时，可能会导致容器状态不一致，所以会报错
 * @author yangqc
 *
 * 2016-6-15
 */
public class FailFast {
	public static void main(String[] args) {
		List<String> c=new ArrayList<>();
		c.add("An Object");
		System.out.println(c.size());
		Iterator<String> it=c.iterator();
		c.remove(0);
		c.add(0, "123");
		System.out.println(c.size());
		try{
			String s=it.next();
		}catch(ConcurrentModificationException e){
			System.out.println(e);
		}
	}
}
