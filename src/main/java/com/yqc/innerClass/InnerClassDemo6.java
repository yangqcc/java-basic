package com.yqc.innerClass;

/*
 * 匿名内部类
 *    内部类的简化写法
 *  格式:
 *    new 类名或者接口名(){
 *      重写方法;
 *    }
 * 本质是什么？
 *   本质是一个继承了该类或者实现了该接口的子类的匿名对象。
 */
public class InnerClassDemo6 {
	public static void main(String[] args) {
		Outer5 o = new Outer5();
		o.method();
	}
}

interface Inter {
	public abstract void show();

	public abstract void show2();
}

class Outer5 {
	public void method() {
		// 一个方法的时候
		/*
		 * new Inter(){ public void show(){ System.out.println("show"); }
		 * }.show();
		 */
		// 两个方法的时候
		/*
		new Inter() {
			public void show() {
				System.out.println("show");
			}

			public void show2() {
				System.out.println("show2");
			}
		}.show2();
		new Inter() {
			public void show() {
				System.out.println("show");
			}
			
			public void show2() {
				System.out.println("show2");
			}
		}.show();
		*/
		//如果有很多方法，就很麻烦
		//改进方案
		Inter i=new Inter(){
			public void show(){
				System.out.println("show");
			}
			public void show2(){
				System.out.println("show2");
			}
		};
		i.show();
		i.show2();
	}
}
