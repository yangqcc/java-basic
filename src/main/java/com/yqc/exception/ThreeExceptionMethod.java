/*
 * 定义自己的Exception类
 * 2015.2.11
 */
package com.yqc.exception;

class MyFirstException extends Exception{
	public MyFirstException(){
		super();
	}
	public MyFirstException(String msg){
		super(msg);
	}
	public MyFirstException(String msg, Throwable cause){
		super(msg,cause);
	}
	public MyFirstException(Throwable cause) {
        super(cause);
    }
	public String toString(){
		return "哈哈,toString被我重写啦!";
	}
}
class MySecondException extends Throwable{
	public MySecondException(){
		super();
	}
	public MySecondException(String msg){
		super(msg);
	}
	public MySecondException(String msg,Throwable cause){
		super(msg,cause);
	}
}
public class ThreeExceptionMethod {
	public static void firstException() throws MyFirstException{
		throw new MyFirstException(" 'firstException()' method occurs an exception!");
	}
	public static void secondException() throws MySecondException{
		int a=1;
		throw new MySecondException(" 'secondException()' method occurs an exception!");
	}
	public static void main(String[] aegs){
		try{
			firstException();
		}catch(MyFirstException e){
			System.out.println("Exception:"+e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace(System.err);
		}
		System.out.println("----------------------------");
		try{
			secondException();
		}catch(MySecondException e){
			e.printStackTrace(System.err);
		}
	}
}
