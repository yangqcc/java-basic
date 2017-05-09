package com.yqc.innerClass;

/*
 * 匿名内部类面试题
 *   按照要求，补全代码
 *   interface Inter{ void show();}
 *   class Outer{//补齐代码
 *      public static void main(String[] args){
 *          Outer.method().show();
 *        }
 *    }
 *   要求控制台输出“Hello World”;
 */
interface Interr {
	void show();
}

class Outer8 {
	public static Interr method() {
		// 子类对象--匿名对象
		return new Interr() {
			public void show() {
				System.out.println("Hello World!");
			}
		};
	}
}

public class InnerClassDemo8 {
	public static void main(String[] args) {
		Outer8.method().show();
	}
	/*
	 * 1.method()应该是Outer8中的静态方法 2.Outer.method().show() 可以看出这个方法的返回值是一个对象
	 * 又由于接口Inter只能够有一个show方法，所以method方法的返回值类型是一个 接口
	 */
}
