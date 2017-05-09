package com.yqc.innerClass;

/*
 * 局部内部类
 *   A:可以直接访问外部类的成员
 *   B:可以创建内部类的对象，通过对象调用内部类的方法，来使用局部内部类的功能
 *   
 *   面试题，局部内部类访问局部变量的注意事项?
 *     局部内部类访问局部变量必须用final修饰
 */
public class InnerClassDemo5 {
	public static void main(String[] args) {
		Outer3 o=new Outer3();
		o.method();
	}
}

class Outer3 {
	private int num = 10;

	public void method() {
		final int num2=20;
		class Inner {
			public void show() {
				//从内部类中访问本地变量num2，需要被声明为最终类型final
				System.out.println(num2);
				System.out.println(num);
			}
		} 
		Inner i = new Inner();
		i.show();
	}
}
