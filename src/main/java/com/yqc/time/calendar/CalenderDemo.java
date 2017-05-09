package com.yqc.time.calendar;

import java.util.Calendar;

/*
 * Calendar
 * 
 * public int get(int field)返回给定日历字段的值
 * 日历类中的每个字段都是静态的成员变量，并且都是int类型
 * 2015.10.7
 */
public class CalenderDemo {
	public static void main(String[] args) {
		Calendar rightNow=Calendar.getInstance();
		//获取年
		int year=rightNow.get(Calendar.YEAR);
		int month=rightNow.get(Calendar.MONTH);
		int day=rightNow.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"年"+(month+1)+"月"+day+"日");
	}
}
