package com.yqc.string;

import java.util.*;

public class InfiniteRecursion {
	public String toString() {
		return " InfiniteRecursion address: " + super.toString() + "\n";
	}

	/*
	 * 打印地址不能用this方法,会产生递归调用，而应该用Object的toString方法，
	 * 而所有类都是继承自Object类，所以用super.toString()
	 * 
	 * public class InfiniteRecursion { public String toString(){ return
	 * " InfiniteRecursion address: "+this+"\n"; }
	 * 这里就会产生递归调用，因为编译器看到String对象后面跟着一个+号，而后面的
	 * 对象不是String，于是编译器就将this转换成一个String，转换方法正是通过 上面的toString方法，于是变会产生递归调用，就会报错。
	 */
	public static void main(String[] args) {
		List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for (int i = 0; i < 10; i++)
			v.add(new InfiniteRecursion());
		System.out.print(v);
	}
}
