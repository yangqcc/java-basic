package com.yqc.time.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 算一下你来到世界多少天
 * 
 * 录入年月日
 * 把该字符串转换为一个日期
 * 通过该日期得到一个毫秒值
 * 获取当前时间毫秒值
 * 把毫秒值转化为年
 * 
 * 2015.10.7
 */
public class MyYearOldDemo {
	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入你的出生年月日");
		String line=sc.nextLine();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d=sdf.parse(line);
		//通过该日期获取一个毫秒值
		long myTime=d.getTime();
		long nowTime=System.currentTimeMillis();
		long time=nowTime-myTime;
		long day=time/1000/60/60/24;
		System.out.println("你来到这个世界:"+day+"天");
	}
}
