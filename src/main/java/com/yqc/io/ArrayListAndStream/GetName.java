package com.yqc.io.ArrayListAndStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
 * 需求：随机获取名字
 * 
 * A:把文本中的数据存储到集合中
 * B:随机产生一个索引
 * C:根据该索引获取一个值
 */
public class GetName {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("b.txt"));
		ArrayList<String> array = new ArrayList<String>();
		String line = null;
		while((line=br.readLine())!=null)
			array.add(line);
		br.close();
		Random r=new Random();
		int index=r.nextInt(array.size());
		String name=array.get(index);
		System.out.println("该幸运者是:"+name);
	}
}
