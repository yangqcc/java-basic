package com.yqc.testInnerClass;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class TestString {
	private String string;
	private int a = 10;
	static Unsafe unsafe;
	static {
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe) field.get(null);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public void changeString(String s) throws NoSuchFieldException, SecurityException {
		this.string = s;
		System.out.println(unsafe.objectFieldOffset(TestString.class.getDeclaredField("string")));
		string += "abc";
		System.out.println(unsafe.objectFieldOffset(TestString.class.getDeclaredField("string")));
		string = new String("123");
		System.out.println(unsafe.objectFieldOffset(TestString.class.getDeclaredField("string")));
		System.out.println(unsafe.objectFieldOffset(TestString.class.getDeclaredField("a")));
		a = 19999;
		System.out.println(unsafe.staticFieldOffset(TestString.class.getDeclaredField("a")));
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		String s = "123";
		new TestString().changeString(s);
	}
}
