package com.yqc.innerClass;

/*
 * 案例：
 *   我有一个人（人有身体，身体有心脏）
 */
public class InnerClassDemo4 {
	public static void main(String[] args) {
//		Outer1.Inner oi=new Outer1().new Inner();  这句是错误的，被静态修饰的内部类不能被外部对象访问
		//格式：  外部类名.内部类名 对象名=new 外部类名.内部类名();
		Outer1.Inner oi=new Outer1.Inner();
		oi.show();
		oi.show2();
		Outer1.Inner.show2();//show2的另一种调用方式
	}
}

//class Body {
//	private class Heart {
//		public void operator() {
//			System.out.println("心脏搭桥");
//		}
//	}
//
//	public void method(){
//		if(){
//			Heart h=new Heart();
//		h.operator();
//		}
//	}
//}
class Outer1{
	private int num=10;
	private static int num2=100;
	public static class Inner{
		public void show(){
			System.out.println(num2);
		}
		public static void show2(){
			System.out.println(num2);
		}
	}
}