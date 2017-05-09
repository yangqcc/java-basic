package com.yqc.io.ArrayListAndStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * 从文本文件中读取数据到集合中，并且遍历集合
 * 
 * 数据源:b.txt---BufferedReader
 * 
 * 目的地ArrayList
 */
public class FileToArrayListDemo {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("b.txt"));
		ArrayList<String> array=new ArrayList<String>();
		String line=null;
		while((line=br.readLine())!=null)
			array.add(line);
		br.close();
		for(String s:array)
			System.out.println(s);
	}
}
