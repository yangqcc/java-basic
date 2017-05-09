package com.yqc.string;
/*
 * StringBuffer的删除功能
 *   public StringBuffer deleteCharAt(int index)  删除指定位置的字符并返回本身
 *   public StirngBuffer delete(int start,int end)  删除从指定位置开始到指定位置结束的字符串
 */
public class StringBufferDelete {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		sb.append("hello").append("world").append("java");
		System.out.println("sb:"+sb);
		//需求：删除e这个字符
//		sb.deleteCharAt(1);
//		System.out.println("sb:"+sb);
//		//删除第一个l
//		sb.deleteCharAt(1);//注意，这里是1
//		System.out.println("sb:"+sb);
		//public StirngBuffer delete(int start,int end)  删除从指定位置开始到指定位置结束的字符串
		//删除world这个字符串
//		sb.delete(5, 10);
//		System.out.println("sb:"+sb);
		//删除所有数据
		sb.delete(0, sb.length());
		System.out.println("sb:"+sb);
	}
}
