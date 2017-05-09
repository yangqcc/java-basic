package com.yqc.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * 新IO简单测试
 * FileOutputStream FileInputStream RandomAccessFile 可以获取通道
 * 但是Reader和Writer不能获取通道
 * 因为通道底层毕竟也是字节流
 * @author yangqc
 * 2016/6/1
 */
public class GetChannel {
	private static final int BSIZE=1024;
	public static void main(String[] args) throws IOException {
		FileChannel fc=new FileOutputStream("data.txt").getChannel();    //获取通道 
		fc.write(ByteBuffer.wrap("Some text \n".getBytes()));  //写入
		fc.close();
		fc=new RandomAccessFile("data.txt","rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("Some more".getBytes()));
		fc.close();
		fc=new FileInputStream("data.txt").getChannel();
		ByteBuffer buff=ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();   //一旦调用read就必须调用flip让缓冲区做好让别人读取数据的准备
		while(buff.hasRemaining()){
			System.out.print((char)buff.get());
		}
	}
}
