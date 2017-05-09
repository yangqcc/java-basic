package com.yqc.math.BigDecimal;

import java.math.BigDecimal;

/*
 * BigDecimal
 * 由于在运算的时候，float类型和double类型很容易丢失精度，所以为了能精确的表示，计算浮点数
 * java提供了BigDecimal
 * 
 * BigDecimal类概述
 * 不可变的，任意精度的有符号十进制数
 * 
 * 构造方法
 * public BigDecimal(String val);
 * 
 * 可以解决因为精度数据丢失问题
 * 
 * 2015.10.2
 */
public class BigDecimalDemo1 {
	public static void main(String[] args) {
		//注意下面的结果 float 和 double精度
		System.out.println(0.09+0.01);
		System.out.println(1.0-0.32);
		System.out.println(1.015*100);
		System.out.println(1.301/100);
		
		System.out.println(1.0-0.12);
		
		BigDecimal bd1=new BigDecimal("0.09");
		BigDecimal bd2=new BigDecimal("0.01");
		System.out.println(bd1.add(bd2));
	}
}
