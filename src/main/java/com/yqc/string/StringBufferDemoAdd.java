package com.yqc.string;
/*
 * 添加功能
 *    public StringBuffer append(String str) 可以把任意类型添加到字符串缓冲区里面,并返回字符串缓冲区本身
 *    
 *    public StringBuffer insert(int offset,String str);在指定位置把任意类型的数据插入里面
 */
public class StringBufferDemoAdd {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		StringBuffer sb2=sb.append("hello");//返回的是它本身，没有重新开空间
		System.out.println("sb:"+sb);
		System.out.println("sb2:"+sb2);
		System.out.println(sb==sb2);
//		sb.append("hello");//可以添加任何东西
//		sb.append(true);
//		sb.append(12);
//		sb.append(34.56);
		sb.append("hello").append(true).append(12).append(24.56);
		System.out.println("sb:"+sb);
		// public StringBuffer insert(int offset,String str);在指定位置把任意类型的数据插入里面
		sb.insert(5, "world");
		System.out.println("sb:"+sb);
	}
}
