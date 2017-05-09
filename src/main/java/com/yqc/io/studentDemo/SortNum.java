package com.yqc.io.studentDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/*
 * A:把s.txt这个文件做出来
 * B:读取该文件的内容，存储得到一个字符串中
 * C:把字符串转换为字符数组
 * D:对字符进行排序
 */
public class SortNum {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("s.txt"));
		String line=br.readLine();
		br.close();
		char[] chs=line.toCharArray();
		Arrays.sort(chs);
		String s=new String(chs);
		BufferedWriter bw=new BufferedWriter(new FileWriter("ss.txt"));
		bw.write(s);
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
