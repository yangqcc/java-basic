package com.yqc.math.BigInteger;

import java.math.BigInteger;

/*
 * public BigInteger add(BigInteger val); 加
 * public BigInteger subtract(BigInteger val); 减
 * public BigInteger multiply(BigInteger val); 乘
 * public BigInteger divide(BigInteger val); 除
 * public BigInteger[] divideAndRemainder(BigInteger val)
 * 返回商和余数的数组
 * 2015.10.2
 */
public class BigIntegerDemo2 {
	public static void main(String[] args) {
		BigInteger big1=new BigInteger("100");
		BigInteger big2=new BigInteger("90");
		
		System.out.println("add:"+big1.add(big2));
		System.out.println("dubtract:"+big1.subtract(big2));
		System.out.println("multiple:"+big1.multiply(big2));
		System.out.println("divide:"+big1.divide(big2)); //这里只是商
		
		BigInteger[] bis=big1.divideAndRemainder(big2);
		System.out.println("商:"+bis[0]);
		System.out.println("余数:"+bis[1]);
	}
}
