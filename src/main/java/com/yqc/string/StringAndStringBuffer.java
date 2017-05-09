package com.yqc.string;
/*
 * String和StringBuffer的相互转换
 * A转换为B其实是为了使用B的功能
 * 如果还要使用A的类型，所以还要转回来
 */
public class StringAndStringBuffer {
	public static void main(String[] args) {
		String s="hello";
		//不能直接把字符串的值赋值给StringBuffer
//		StringBuffer sb=s;
		//下面是两种将String转成StringBuffer的方法:
		StringBuffer sb=new StringBuffer(s);
		StringBuffer sb2=new StringBuffer();
		sb2.append(s);
		
		
		System.out.println("sb:"+sb);
		System.out.println("sb2:"+sb2);
		StringBuffer buffer=new StringBuffer("java");
		//String(StringBuffer buffer)
		//1.构造方法
		String str=new String(buffer);
		//2.通过toString方法
		String str2=buffer.toString();
		System.out.println("str:"+str);
		System.out.println("str2:"+str2);
	}
}
