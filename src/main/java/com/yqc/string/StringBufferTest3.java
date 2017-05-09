package com.yqc.string;

import java.util.Scanner;

/*
 * 字符串反转
 */
public class StringBufferTest3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数据:");
		String s=sc.nextLine();
		System.out.println(myReverse2(s));
	}
	//StringBuffer的反转功能
	public static String myReverse2(String s){
		return new StringBuffer(s).reverse().toString();
	}
	public static String myReverse(String s){
		String result="";
		char [] chs=s.toCharArray();
		for(int i=chs.length-1;i>=0;i--)
			result+=chs[i];
		return result;
	}
}
