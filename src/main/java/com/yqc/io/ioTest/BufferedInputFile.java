package com.yqc.io.ioTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 流的组合
 * @author yangqc
 * 2016.5.29
 */
public class BufferedInputFile {
	public static String read(String filename) throws IOException{
		BufferedReader in=new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb=new StringBuilder();
		while((s=in.readLine())!=null)
			sb.append(s+"\n");  //必须加换行符，因为readline()已经将他们删掉了
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		System.out.println(read("src/com/yqc/ioTest/BufferedInputFile.java"));
	}
}
