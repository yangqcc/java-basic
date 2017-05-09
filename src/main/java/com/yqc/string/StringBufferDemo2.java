package com.yqc.string;

/*
 * 拼接字符串
 */
public class StringBufferDemo2 {
	public static void main(String[] args) {
		int[] arr = { 44, 33, 55, 11, 22 };
		String s1=arrayToString2(arr);
		System.out.println(s1);
	}
	//用StringBuffer做拼接
	public static String arrayToString2(int[] arr){
		StringBuffer sb=new StringBuffer();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				sb.append(arr[i]);
			} else
				sb.append(arr[i]).append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	public static String arrayToString(int[] arr) {
		String s = ""; 
		s += "[";
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				s += arr[i];
			} else {
				s += arr[i];
				s += ",";
			}
		}
		s += "]";
		return s;
	}
}
