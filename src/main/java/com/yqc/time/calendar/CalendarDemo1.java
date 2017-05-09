package com.yqc.time.calendar;

import java.util.Calendar;

/*
 * public void add(int field,int amount);根绝给定的日历字段和对应的时间，来对当前日历进行操作
 * 
 * public final void set(int year,int month,int date)
 */
public class CalendarDemo1 {
	public static void main(String[] args) {
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH);
		int day=c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"年"+(month+1)+"月"+day+"日");
		
		//三年前的今天
		c.add(Calendar.YEAR, -3);
		year=c.get(Calendar.YEAR);
		month=c.get(Calendar.MONTH);
	    day=c.get(Calendar.DAY_OF_MONTH);
	    System.out.println(year+"年"+(month+1)+"月"+day+"日");
	    
	    //五年后的十天前
	    c.add(Calendar.YEAR, 5);
	    c.add(Calendar.DAY_OF_MONTH, -10);
	    year=c.get(Calendar.YEAR);
		month=c.get(Calendar.MONTH);
	    day=c.get(Calendar.DAY_OF_MONTH);
	    System.out.println(year+"年"+(month+1)+"月"+day+"日");
	    
	    
	    c.set(2011, 11,11);
	    year=c.get(Calendar.YEAR);
		month=c.get(Calendar.MONTH);
	    day=c.get(Calendar.DAY_OF_MONTH);
	    System.out.println(year+"年"+(month+1)+"月"+day+"日");
	}
}
