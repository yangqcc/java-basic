package com.yqc.collection.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * 用集合存储5个学生对象，并把学生对象进行遍历
 * 
 * 
 * 2015.10.8
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection<Student> c=new ArrayList<>();
		Student s1=new Student("期成",1);
		Student s2=new Student("诗佳",2);
		Student s3=new Student("超超",3);
		Student s4=new Student("林佳",4);
		Student s5=new Student("问问",5);
		c.add(s1);
		c.add(s2);
		c.add(s3);
		c.add(s4);
		c.add(s5);
		//把集合转成数组
		Object[] stus=(Object[]) c.toArray();
		for(int i=0;i<stus.length;i++){
			System.out.println(((Student)stus[i]).getName());
		}
		
		//迭代器遍历
		Iterator ita=c.iterator();
		while(ita.hasNext()){
			Student s=(Student) ita.next();
			System.out.println(s.getAge()+"---"+s.getName());
		}
	}
}
