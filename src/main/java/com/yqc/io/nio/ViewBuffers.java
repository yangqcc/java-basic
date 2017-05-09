package com.yqc.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/**
 * 缓冲区与视图
 * 
 * @author yangqc 2016/1/21
 */
public class ViewBuffers {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer
				.wrap(new byte[] { 0, 0, 0, 0, 0, 0, 0, 'a' });
		bb.rewind(); // 重绕缓冲区，将位置标记为零，并丢弃标记  rewind会返回一个Buffer ，Buffer是所有
		//视图以及ByteBuffer的超类
		System.out.println("Byte Buffer");
		while (bb.hasRemaining())  //告知当前位置和限制之间是否还有元素
			System.out.println(bb.position() + "->" + bb.get() + ", ");
		System.out.println();
		CharBuffer cb = ((ByteBuffer) bb.rewind()).asCharBuffer();
		while (cb.hasRemaining())
			System.out.println(cb.position() + "->" + cb.get() + ", ");
		System.out.println();
		IntBuffer ib = ((ByteBuffer) bb.rewind()).asIntBuffer();
		System.out.println("IntBuffer");
		while (ib.hasRemaining())
			System.out.println(ib.position() + "->" + ib.get() + ", ");
		System.out.println();
		FloatBuffer fb = ((ByteBuffer) bb.rewind()).asFloatBuffer();
		while (fb.hasRemaining())
			System.out.println(fb.position() + "->" + fb.get() + ", ");
		System.out.println();
		LongBuffer lb = ((ByteBuffer) bb.rewind()).asLongBuffer();
		while(lb.hasRemaining())
			System.out.println(lb.position()+"->"+lb.get()+",");
		System.out.println();
		ShortBuffer sb=((ByteBuffer)bb.rewind()).asShortBuffer();
		while(sb.hasRemaining())
			System.out.println(sb.position()+"->"+sb.get()+", ");
		System.out.println();
		DoubleBuffer db=((ByteBuffer)bb.rewind()).asDoubleBuffer();
		while(db.hasRemaining())
			System.out.println(db.position()+"->"+db.get()+", ");
		System.out.println();
	}
}
