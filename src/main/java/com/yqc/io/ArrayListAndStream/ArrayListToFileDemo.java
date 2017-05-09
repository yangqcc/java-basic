package com.yqc.io.ArrayListAndStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * 需求，把ArrayList集合中的字符串存储到文本文件中
 * 
 * 分析：
 *    通过题目的意思我们可以知道如下一些内容
 *    ArrayLisr集合存储的字符串
 *    
 *    数据源：
 *    ArrayList遍历得到每一个字符串数据
 *    
 *    BufferedWriter
 */
public class ArrayListToFileDemo {
	public static void main(String[] args) throws IOException {
		ArrayList<String> array=new ArrayList<String>();
		array.add("hello");
		array.add("world");
		array.add("java");
		//封装目的地
		BufferedWriter bw=new BufferedWriter(new FileWriter("a.txt"));
		for(String s:array){
			bw.write(s);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
}
