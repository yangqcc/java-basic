package com.yqc.time.date;

import java.util.Date;

/*
 * Date 特定瞬间，精确到毫秒
 * 
 * 构造方法
 * 
 * Date()根据当前默认毫秒之创建日期对象
 * 
 * Date(long date)  根绝给定的毫秒值创建日期对象
 * 分配Date对象并初始化此对象，以此表示自从标准基准时间，即1970年1月1日以来指定的毫秒值
 * 2015.10.6
 */
public class DateDemo1 {
	public static void main(String[] args) {
		//
		Date d=new Date();
		System.out.println(d.toString());
		
		//long time=System.currentTimeMillis();
		long time=30000;
		Date d2=new Date(time);
		System.out.println(d2);
	}
}
