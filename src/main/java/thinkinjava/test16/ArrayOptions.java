package thinkinjava.test16;

import java.util.Arrays;
/*
 * 几种创建数组的对象的方式，记住，a[] v=new a[]{}这种方式表示创建了一个长度为0的数组对象
 * 1.对象数组中存储的是对象的引用
 * 2.基本类型数组中存放的是基本类型的数值
 * 3.如果数组没有初始化，其保存的对象自动初始化null，int,char自动初始化为0，boolean初始化为false
 * 2015.8.31
 */
public class ArrayOptions {
	public static void main(String[] args) {
		BerylliumSphere[] a;
		BerylliumSphere[] e=new BerylliumSphere[]{};//这里表示创建了一个数组对象，但是数组长度为0，不能向里面放入对象
		BerylliumSphere[] b = new BerylliumSphere[5];
		System.out.println("b: " + Arrays.toString(b));
		BerylliumSphere[] c = new BerylliumSphere[4];
		for (int i = 0; i < c.length; i++) {
			if (c[i] == null) {
				c[i] = new BerylliumSphere();
			}
		}
		BerylliumSphere[] d = { new BerylliumSphere(), new BerylliumSphere(),
				new BerylliumSphere() };//这里是普通聚集话初始方式，隐式的在堆里面创建了一个数组对象

		a = new BerylliumSphere[] { new BerylliumSphere(),
				new BerylliumSphere() };
		
//		for(int i=0;i<100;i++){
//			e[i]=new BerylliumSphere();
//		}
		System.out.println("a.length= " + a.length);
		System.out.println("b.length= " + b.length);
		System.out.println("c.length= " + c.length);
		System.out.println("d.length= " + d.length);
		System.out.println("e.length= " + e.length);
		a = d;
		System.out.println("a.length= " + a.length);
	}
}
