package com.yqc.time.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 日期格式化
 * Date----String
 *   public final String format(Date date)
 *   
 * String---Date
 * 
 * DateFormat可以进行日期和字符串的格式化和解析
 * 
 * SimpleDateFormat构造方法
 * 
 * SimpleDateFormat()默认模式
 * SimpleDateFormat(String pattern)给定模式
 * 
 * 2015.10.7
 */
public class DateDemo3 {
	public static void main(String[] args) throws ParseException {
		//创建Date
		Date d=new Date();
		//SimpleDateFormat sdf=new SimpleDateFormat();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String s=sdf.format(d);
		System.out.println(s);
		
		String str="2008-08-08 12:12:12";
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdf2.parse(str);
		System.out.println("date:"+date);
	}
}
