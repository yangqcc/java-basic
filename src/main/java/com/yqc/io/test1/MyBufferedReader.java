package com.yqc.io.test1;

import java.io.IOException;
import java.io.Reader;

/*
 * 用Reader魔力BufferedReader的readerLine()的功能
 */
public class MyBufferedReader {
	private Reader r;
	public MyBufferedReader(Reader r){
		this.r=r;
	}
//	public String readerLine(){
		/*
		 * 返回一个字符串
		 * 看看r对象能够提供什么方法
		 * 返回一个字符串，用什么方法比较好
		 * 使用字符串缓冲区对象
		 */
		
//	}
	public void close() throws IOException{
		this.r.close();
	}
}
