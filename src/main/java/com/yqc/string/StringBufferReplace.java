package com.yqc.string;
/*
 * StringBuffer反转功能
 *   public StringBuffer reverse()
 * 
 * 截取功能:注意返回值类型不再是StringBuffer，而是String了
 *   public String substring(int start);
 *   public String substring(int start,int end);
 */
public class StringBufferReplace {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		sb.append("陆昀我爱你");
		System.out.println("sb:"+sb);
		sb.reverse();
		System.out.println("sb:"+sb);
		//创建StringBuffer
		StringBuffer sb2=new StringBuffer();
		sb2.append("hello").append("world").append("java");
		String s=sb2.substring(5);
		System.out.println("sb2:"+sb2);
		System.out.println("s:"+s);
	    String ss=sb2.substring(5, 10);
	    System.out.println(ss);
	} 
}
