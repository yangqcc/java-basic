package com.yqc.exception;

import java.io.FileReader;

public class Test3 {
	public static void main(String[] args) throws Exception{
    Father father =new Father();
    father.test1();
	}
}
//抛异常也会占资源
//所以最好catch
class Father {
	private Son son=null;
    public Father()
    {
    	son=new Son();
    }
	public void test1() throws Exception{//这里是抛出异常
		try{
		son.test2();
		}catch(Exception e){
			System.out.println("父亲");
			e.printStackTrace();//错误在这里被捕获
		}
		System.out.println("1");
	}
}

class Son {
	public void test2() throws Exception{
		FileReader fr=null;
		System.out.println("2");
		fr=new FileReader("d:\\d.txt");
	}
}