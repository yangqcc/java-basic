package com.yqc.testInnerClass;

import java.util.Arrays;

/**
 * 测试final修饰的数组可否被改变
 *
 * @author yangqc 2016年9月19日
 */
public class TestFinalArray {
	private final Integer[] a;
	private Integer[] b;

	public TestFinalArray(Integer[] a) {
		this.a = a;
	}

	public void setB(Integer[] b) {
		this.b = b;
		System.out.println(Arrays.toString(b));
	}

	public void changeArray(int index, Integer currentValue) {
		if (index > a.length || index < 0) {
			throw new IllegalArgumentException();
		}
		a[index] = currentValue;
	}

	// 无法通过编译
	// public void setA(Integer[] a){
	// this.a=a;
	// }

	public static void main(String[] args) {
		Integer[] a = new Integer[10];
		for (int i = 0; i < 10; i++) {
			a[i] = i;
		}
		TestFinalArray test = new TestFinalArray(a);
		test.changeArray(0, 10);
		System.out.println(Arrays.toString(a));
		test.setB(a);
		test.setB(new Integer[] { 1, 2, 3 });
	}
}
