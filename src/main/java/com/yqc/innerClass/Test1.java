package com.yqc.innerClass;
/*
 * 需求：访问Inner类的show()方法
 * Inner是成员内部类
 * 外部类.内部类名 对象名=外部类对象.内部类对象
 */
public class Test1 {
	public static void main(String[] args) {
		Outer.Inner in=new Outer().new Inner();
		in.show();
	}
}

class Outer {
	private int num = 10;

	class Inner {
		public void show() {
			System.out.println(num);
		}
	}
}