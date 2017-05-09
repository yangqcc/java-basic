package com.yqc.math.SystemTest;
/*
 * system不能被实例化,都是静态方法
 * 
 * 方法:
 * public static void gc()  垃圾回收器
 * public static void exit(int status)
 * public static long currentTimeMillis
 * 
 */
public class SystemDemo {
	public static void main(String[] args) {
		Person p=new Person("期成",60);
		System.out.println(p);
		p=null;
		System.gc();
	}
}
