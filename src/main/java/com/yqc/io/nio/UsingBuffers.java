package com.yqc.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
/**
 * 下面是remind方法、
 * public final Buffer rewind()重绕此缓冲区。将位置设置为 0 并丢弃标记。 
      在一系列通道写入或获取 操作之前调用此方法（假定已经适当设置了限制）。例如： 

    out.write(buf);    // Write remaining data
    buf.rewind();      // Rewind buffer
    buf.get(array);    // Copy data into array
       返回：
       此缓冲区

 * @author yangqc 
 *
 */
public class UsingBuffers {
	private static void symmericScramble(CharBuffer buffer){
		while(buffer.hasRemaining()){
			buffer.mark();
			char c1=buffer.get();
			char c2=buffer.get();
			buffer.reset();
			buffer.put(c2).put(c1);
		}
	}
	public static void main(String[] args) {
		char[] data="UsingBuffers".toCharArray();
		ByteBuffer bb=ByteBuffer.allocate(data.length*2);
		CharBuffer cb=bb.asCharBuffer();
		cb.put(data);
		System.out.println(cb.rewind());
		symmericScramble(cb);
		System.out.println(cb.rewind());
		symmericScramble(cb);
		System.out.println(cb.rewind());
	}
}
