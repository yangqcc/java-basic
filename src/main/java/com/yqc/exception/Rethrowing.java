/*
 * 将Exception抛向上一级引用
 * fillInStackTrace方法
 * 2015.2.11
 */
package com.yqc.exception;

public class Rethrowing {
	public static void f() throws Exception{
		System.out.println("originating the exception in f()");
		throw new Exception("throw from f()");
	}
	public static void g() throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("Inside() g(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	public static void h() throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("Insede h(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();//fillInStackTrace() 用当前栈的信息填充异常的信息
		}
	}
	public static void main(String[] args){
		try{
			g();
		}catch(Exception e){
			System.out.println("main:printStackTrace()");
			e.printStackTrace(System.out);
		}
		try{
			h();
		}catch(Exception e){
			System.out.println("main:printStackTrace()");//异常位置的改变
			e.printStackTrace(System.out);
		}
	}
}
