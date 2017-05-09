package com.yqc.time.date;

import java.util.Date;

/*
 * public long getTime() 获取时间，以毫秒为单位
 * public void setTime(long time) 设置时间
 * 
 * 从Date得到毫秒值
 * 
 * 把毫秒值转换为Date
 * 
 * 2015.10.6
 */
public class DateDemo2 {
	public static void main(String[] args) {
		Date d=new Date();
		long time=d.getTime();
		System.out.println(time);
//		System.out.println(System.currentTimeMillis());
		
		//设置时间
		System.out.println("d:"+d);
		d.setTime(100);
		System.out.println("d:"+d);//注意时区
	}
}
