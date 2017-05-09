package com.yqc.innerClass;
/*
 * 面试题:
 *    要求请填空分别输出30,20,10.
 *    注意：内部类和外部类没有继承关系
 */
public class InnerClassTest {
	public static void main(String[] args) {
		Outerr.Inner oi=new Outerr().new Inner();
		oi.show();
	}
} 
class Outerr{
	public int num=10;
	class Inner{
		public int num=20;
		public void show(){
			int num=30;
			System.out.println(num);
			System.out.println(this.num);
//			System.out.println(new Outerr().num);
			System.out.println(Outerr.this.num);//注意。这里重要，通过外部类名限定this对象
		}
	}
}