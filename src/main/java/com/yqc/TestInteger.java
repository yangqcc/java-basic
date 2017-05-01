package com.yqc;

/**
 * equals方法不会处理数据转换类型 包装器类的==在不遇到算术运算的情况下不会自动拆箱
 * 
 * @author yangqc 2016年12月20日
 */
public class TestInteger {
	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;

		System.out.println(c == d);
		System.out.println(e == f);
		System.out.println(c == (a + b));
		System.out.println(c.equals(a + b));
		System.out.println(g == (a + b));  //拆箱
		System.out.println(g.equals(a + b));
	}
}
