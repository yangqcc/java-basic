package com.yqc.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
/**
 * MappedByteBuffer是从ByteBuffer继承而来
 * @author yangqc
 * 2016.6.2
 * 大文件操作，可以在底层操作很大的文件
 */
public class LargeMappedFiles {
	static int length=0x8FFFFFF; //128MB
	public static void main(String[] args) throws FileNotFoundException, IOException {
		MappedByteBuffer out=new RandomAccessFile("text.dat","rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);//这意味着可以映射大文件较小的部分
		for(int i=0;i<length;i++)
			out.put((byte)'x');
		for(int i=length/2;i<length/2+6;i++)
			System.out.println((char)out.get(i));
	}
}
