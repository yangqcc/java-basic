package com.yqc.io.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 复制图片
 *   字节流
 *   4种方式
 */
public class CopyPicture {
	public static void main(String[] args) throws IOException {
		// String srcString="File类.png";
		// 使用File对象作为参数
		File srcFile = new File("File类.png");
		File destFile = new File("D:\\help.png");
		// method1(srcFile,destFile);
		method2(srcFile, destFile);
		// method3(srcFile,destFile);
		// method4(srcFile,destFile);
	}

	private static void method2(File srcFile, File destFile) throws IOException {
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		byte[] chs = new byte[1024];
		int len = 0;
		while ((len = fis.read(chs)) != -1)
			fos.write(chs, 0, len);
		fis.close();
		fos.close();
	}

	// 一次读写一个字节
	private static void method1(File srcFile, File destFile) throws IOException {
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		int ch = 0;
		while ((ch = fis.read()) != -1)
			fos.write(ch);
		fis.close();
		fos.close();
	}
}
