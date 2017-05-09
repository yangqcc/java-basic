package com.yqc.io.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 复制文件
 * 采用字符流
 * 
 * 字符流5种方式
 *   数据源:--FileReader ---BufferedReader
 *   目的地:
 */
public class CopyFileDemo {
	public static void main(String[] args) throws IOException {
		String srcString = "Copy.java";
		String destString = "d:\\copy.txt";
		try {
			method1(srcString, destString);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		 method2(srcString,destString);
//		 method3(srcString,destString);
//		 method4(srcString,destString);
//		 method5(srcString,destString);
	}
	
	private static void method5(String srcString, String destString) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(srcString));
		BufferedWriter bw=new BufferedWriter(new FileWriter(destString));
		String line=null;
		while((line=br.readLine())!=null){
			bw.write(line);
			System.out.println(line);
		}
		br.close();
		bw.close();
	}

	private static void method4(String srcString, String destString) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(srcString));
		BufferedWriter bw=new BufferedWriter(new FileWriter(destString));
		char[] chs=new char[1024];
		int len=0;
		while((len=br.read(chs))!=-1){
			bw.write(chs,0,len);
			System.out.print(new String(chs,0,len));
		}
		br.close();
		bw.close();
	}

	private static void method3(String srcString, String destString) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(srcString));
		BufferedWriter bw=new BufferedWriter(new FileWriter(destString));
		int ch=0;
		while((ch=br.read())!=-1)
			bw.write(ch);
		br.close();
		bw.close();
	}

	private static void method2(String srcString, String destString) throws IOException {
		FileReader fr=new FileReader(srcString);
		FileWriter fw=new FileWriter(destString);
		char[] chs=new char[1024];
		int len=0;
		while((len=fr.read(chs))!=-1)
			fw.write(chs,0,len);
	    fr.close();
	    fw.close();
	}

	//基本字符流一次读写一个字符
	private static void method1(String srcString, String destString) throws IOException {
		FileReader fr=new FileReader(srcString);
		FileWriter fw=new FileWriter(destString);
		int ch=0;
		while((ch=fr.read())!=-1){
			fw.write(ch);
			System.out.println(ch);
		}
		fw.close();
		fr.close();
	}
	
}
