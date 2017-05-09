package com.yqc.time.calendar;

import java.util.Calendar;
import java.util.Scanner;

/*
 * 获取任意一年二月有多少天
 * 分析
 * 键盘录入任意年份
 * 设置日历对象的年月日
 * 
 * 
 * 2015.10.7
 * 
 */
public class CalendarDemo3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入年份:");
		int year=sc.nextInt();
		System.out.println("当年二月是:"+getMonthDay(year)+"天");
	}
	public static int getMonthDay(int year){
		Calendar c=Calendar.getInstance();
		c.set(year,2,1);
		c.add(Calendar.DATE, -1);
		return c.get(Calendar.DAY_OF_MONTH);
	}
}
