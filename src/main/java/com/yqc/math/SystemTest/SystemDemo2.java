package com.yqc.math.SystemTest;
/*
 * public static void exit(int status)终止java虚拟机非0表示异常终止
 */
public class SystemDemo2 {
	public static void main(String[] args) {
//		System.out.println("我们喜欢你!");
//		System.exit(0);//终止当前正在运行的虚拟机
//		System.out.println("我们真的喜欢你!");
		
		System.out.println(System.currentTimeMillis());//当前时间的毫秒值
		//统计程序运行时间
		long start=System.currentTimeMillis();
		for(int x=0;x<100000;x++){
			System.out.println("hello"+x);
		}
		long end=System.currentTimeMillis();
		System.out.println("共耗时："+(end-start)+"毫秒");
	}
}
