package com.yqc.innerClass;
/*
 * 链式编程
 *   每次调用方法完后，返回的是一个对象
 */
public class StudentTest {
	public static void main(String[] args) {
		StudentDemo sd=new StudentDemo();
//		Student2 s=sd.getStudent();
//		s.study();
		//注意,这里就是链式编程
		sd.getStudent().study();
	}
}
class Student2{
	public void study(){
		System.out.println("Good Good Study,Day Day Up!");
	}
}
class StudentDemo{
	public Student2 getStudent(){
		return new Student2();
	}
}