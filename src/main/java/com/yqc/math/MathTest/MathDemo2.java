package com.yqc.math.MathTest;

import java.util.Scanner;

/*
 * 需求：设计一个方法，可以获取任意范围的随机数
 * 
 * 分析：
 * 
 * A：键盘录入两个数
 * B：获取随机数
 * C:输出随机数
 */
public class MathDemo2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入随机数:");
		int start=sc.nextInt();
		System.out.println("请输入结束数:");
		int end =sc.nextInt();
		for(int x=0;x<100;x++){
//			int num=getRandom(start,end);
//			System.out.println(num);
		}
	}
//	public static int getRandom(int start,int end){
////		int number=(int)(Math.random()*end)+start;
//		
//		return number;
//	}
}
