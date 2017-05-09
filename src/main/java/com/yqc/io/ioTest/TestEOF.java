package com.yqc.io.ioTest;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {
	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(new BufferedInputStream((new FileInputStream("src/com/yqc/ioTest/TestEOF.java"))));
		while (in.available() != 0)
			// 因为 '\n'也是一个字符，所以只能用available判断是否读到终点,表示没有阻塞的情况下读取的字节数
			System.out.println((char) in.readByte());
	}
}
