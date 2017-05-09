package com.yqc.time.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 日期和字符串相互转换的工具类
 */
public class DateUtil {
	private DateUtil(){};
	
	public static String dateToString(Date d,String format){
//		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return new SimpleDateFormat(format).format(d);
	}
	
	/**
	 * 
	 * @param date
	 *            被解析的字符串
	 * @param format
	 *            传递过来的要被转换的格式
	 *  
	 * @return
	 *      解析后的日期对象
	 * @throws ParseException
	 */
	public static Date stringToDate(String date,String format) throws ParseException{
		return new SimpleDateFormat(format).parse(date);
	}
}
