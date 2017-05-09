package com.yqc.math.BigDecimal;

import java.math.BigDecimal;

/*
 * 构造方法
 * public BigDecimal(double val)  //此方法也有一定不可预知性
 * public BigDecimal(String val)  //此方法很精确，不会有问题
 * 
 * public BigDecimal add(BigDecimal augend)
 * public BigDecimal subtract(BigDecimal augend)
 * public BigDecimal divide(BigDecimal augend)
 * public BigDecimal divide(BigDecimal dividor,int scale,int roundingMode)
 * 商几位小数，如何舍去
 * public BigDecimal multiply(BigDecimal augend)
 * 
 * 2015.10.2
 */
public class BigDecimalDemo2 {
	public static void main(String[] args) {
		BigDecimal bd1=new BigDecimal("0.09");
		BigDecimal bd2=new BigDecimal("0.01");
		System.out.println(bd1.add(bd2));
		
		System.out.println("---------------");
		BigDecimal bd3=new BigDecimal("1.0");
		BigDecimal bd4=new BigDecimal("1.0");
		System.out.println("subtract:"+bd3.subtract(bd4));//减法
		
		System.out.println("-----------------");
		BigDecimal  bd5=new BigDecimal("1.00");
		BigDecimal  bd6=new BigDecimal("2.00");
		System.out.println("multiply:"+bd5.multiply(bd6));
		
		System.out.println("--------------");
		BigDecimal bd7=new BigDecimal("1.890890");
		BigDecimal bd8=new BigDecimal("0.809890");
		System.out.println("divide:"+bd7.divide(bd8,3,BigDecimal.ROUND_HALF_UP));
//		System.out.println("divide:"+bd5);
	}
}
