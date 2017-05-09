package com.yqc.innerClass;
/*
 * 匿名内部类开发中使用
 *  弊端:只能使用一次
 */
public class InnerClassDemo7 {
	public static void main(String[] args) {
		PersonDemo pd=new PersonDemo();
		pd.method(new Person(){
			public void study(){
				System.out.println("好好学习，天天向上!");
			}
		});
	}
}
interface Person{
	public abstract void study();
}
class Student implements Person{
	public void study(){
		System.out.println("好好学习，天天向上");
	}
}
class PersonDemo{
	//接口名作为形式参数 这里需要的不是接口，而是给接口实现类的对象
	public void method(Person p){
		p.study();
	}
}
