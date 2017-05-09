package com.yqc.string;

import java.util.Scanner;

/*
 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñ¶Ô³Æ
 */
public class StringBufferTest4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		System.out.println("ÇëÊäÈë×Ö·û´®:");
		String s=sc.nextLine();
		System.out.println(Judge2(s));
	}
	public static boolean Judge2(String s){
		return new StringBuffer(s).reverse().toString().equals(s);
	}
	public static boolean Judge(String s) {
		String s1=null;
		String s2=null;
		if (s.length() % 2 == 0) {
			s1 = s.substring(0, s.length() / 2);
			s2 = s.substring(s.length() / 2, s.length());
		} else {
			s1 = s.substring(0, s.length() / 2);
			s2 = s.substring((s.length() / 2) + 1, s.length());
		}
		if (s1.equals(s2))
			return true;
		else
			return false;
	}
}
