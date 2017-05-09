/*
 * StringBuilder方法，可以更加方便
 * 2015.2.10
 */
package com.yqc.string;

import java.util.Random;

public class UsingStringBuilder {
	public static Random rand=new Random(47);
	public String toString(){
		StringBuilder result=new StringBuilder("[");
		for(int i=0;i<25;i++){
			result.append(rand.nextInt(100));
			result.append(", ");
		}
		result.delete(result.length()-2, result.length());//消除最后一个逗号和空格
		result.append("]");
		return result.toString();//返回队列的String
	}
	public static void main(String[] args){
		UsingStringBuilder usb=new UsingStringBuilder();
		System.out.println(usb);
	}
}
