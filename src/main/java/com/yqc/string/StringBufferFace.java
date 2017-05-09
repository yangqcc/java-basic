package com.yqc.string;
/*
 * 1.String,StringBuilder,StringBuffer
 *   A:String是内容不可变的，而StringBuffer，StringBuilder都是内容可变的
 *   B:StringBuffer是同步的，数据安全，效率低，StringBuilder是不同步的，数据不安全，效率高
 * 2.StringBuffer和数组的区别
 *   二者都可以看成一个容器，装其他数据
 *   A:StringBuffer可以添加任何类型，但是最终都成为自妇产
 *   B:数组只能存放任意类型的同一种数据，但必须是同一种数据类型
 * 3.形式参数问题
 *   A:String作为参数传递
 *   B:StringBuffer作为参数传递
 *   
 * 形式参数:
 *   基本类型:形式参数的改变不影响实际参数
 *   引用类型:形式参数的改变直接影响实际参数
 *   
 * 注意:
 *   String作为形参，效果和基本类型是一样的
 */
public class StringBufferFace {
	public static void main(String[] args) {
		String s1="hello";
		String s2="world";
		System.out.println(s1+"---"+s2);
		change(s1,s2);
		System.out.println(s1+"---"+s2);
		StringBuffer sb1=new StringBuffer("hello");
		StringBuffer sb2=new StringBuffer("world");
		System.out.println(sb1+"---"+sb2);
		change(sb1,sb2);
		System.out.println(sb1+"---"+sb2);
	}
	private static void change(StringBuffer sb1,StringBuffer sb2){
		sb1=sb2;
		sb2.append(sb1);
	}
	private static void change(String s1, String s2) {
		s1=s2;
		s2=s1+s2;
	}
}
