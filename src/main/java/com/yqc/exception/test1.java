package com.yqc.exception;

import java.io.FileReader;

public class test1 {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("d:\\a.tet");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("1");
		}
		System.out.println("OK");
	}
}
