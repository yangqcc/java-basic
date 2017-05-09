package com.yqc.io.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class Endians {
	public static void main(String[] args) {
		ByteBuffer bb=ByteBuffer.wrap(new byte[12]);
		bb.asCharBuffer().put("abcdef");  //每个char占两个字节
		System.out.println(Arrays.toString(bb.array()));
		bb.rewind();
		bb.order(ByteOrder.BIG_ENDIAN);  //高位优先，重要的字节放在低位
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
		bb.rewind();
		bb.order(ByteOrder.LITTLE_ENDIAN);
		bb.asCharBuffer().put("abcdef");  //低位优先，重要的字节放在高位
		System.out.println(Arrays.toString(bb.array()));
	}
}
