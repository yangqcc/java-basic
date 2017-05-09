package com.yqc.string;
/*
 * 线程安全
 * 安全----同步---数据是安全的（银行取钱）
 * 不安全----不同步---效率高一些
 * 安全和效率问题是永远困扰我们的
 * 安全：医院的网站，银行网站
 * 效率：新闻网站，论坛之类
 * 
 * StringBuffer构造方法
 *    public StringBuffer();无参构造函数
 *    public StringBuffer(int capacity)指定容量的字符串缓冲区对象
 *    public StringBuffer(String str);指定字符串内容的缓冲区对象
 *    
 * StringBuffer的方法:
 *      public int capacity();返回当前容量
 *      public int length()返回长度（字符串）,实际值
 */
public class StringBufferDemo1 {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();//一般用这个
		System.out.println("sb:"+sb);
		System.out.println("sb:"+sb.capacity());
		System.out.println("sb:"+sb.length());
		//指定容量的字符串缓冲区
		StringBuffer sb2=new StringBuffer(50);
		System.out.println("sb:"+sb2);
		System.out.println("sb:"+sb2.capacity());
		System.out.println("sb:"+sb2.length());
		//public StringBuffer(String str);指定字符串内容的缓冲区对象
		StringBuffer sb3=new StringBuffer("hello");
		System.out.println("sb:"+sb3);
		System.out.println("sb:"+sb3.capacity());
		System.out.println("sb:"+sb3.length());
	}
}
