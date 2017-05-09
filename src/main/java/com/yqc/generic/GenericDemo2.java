package com.yqc.generic;

import java.util.Collection;
import java.util.Date;
import java.util.Vector;

/**
 * 泛型函数
 * 
 * 2015.10.20
 * @author yangqc
 *
 */
public class GenericDemo2 {
	public static void main(String[] args) {
		//其实并没有卵用
		//类型推断，结果是交集
		
		//自动装箱
		add(2,4);
		add(2,"adfs");//尼玛，这他妈也行
		Number x=add(2,3.4);//这他妈还是可以
		Object a=add(2,"dsda");//公共部分，Object
		
		swap(new String[]{"21121","dewdwe","dewdew"},1,1);
		//这里报错了，泛型的类型只能是引用类型，不能使基本类型
//		swap(new int[]{1,2,3,4,5},2,3);   //所以这里会报错
		
		//一个
		String s=autoConvert(1);
		
		copy1(new Vector<String>(),new String[10]);
		copy2(new Date[10],new String[10]); //类型推断，很复杂的一个过程
//		copy1(new Date[10],new Date[10]);    //注意这里的错误
	}
	
	
	private static <T> T add(T x,T y){
		return y;
	}
	//交换数组中连个元素的位置
	private static <T> void swap(T[] a,int i,int j){
		T temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	private static <T> T autoConvert(Object obj){
		return (T)obj;
	} 
	private static <T> void fillArray(T[] a,T obj){
		for(int i=0;i<a.length;i++){
			a[i]=obj;
		}
	}
	private static <T> void copy1(Collection<T> dest,T[] src){
	}
	
	private static <T> void copy2(T[] dest,T[] src){
		
	}
}
