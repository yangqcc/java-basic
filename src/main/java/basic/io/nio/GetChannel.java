package basic.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * ��IO�򵥲���
 * FileOutputStream FileInputStream RandomAccessFile ���Ի�ȡͨ��
 * ����Reader��Writer���ܻ�ȡͨ��
 * ��Ϊͨ���ײ�Ͼ�Ҳ���ֽ���
 * @author yangqc
 * 2016/6/1
 */
public class GetChannel {
	private static final int BSIZE=1024;
	public static void main(String[] args) throws IOException {
		FileChannel fc=new FileOutputStream("data.txt").getChannel();    //��ȡͨ�� 
		fc.write(ByteBuffer.wrap("Some text \n".getBytes()));  //д��
		fc.close();
		fc=new RandomAccessFile("data.txt","rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("Some more".getBytes()));
		fc.close();
		fc=new FileInputStream("data.txt").getChannel();
		ByteBuffer buff=ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();   //һ������read�ͱ������flip�û����������ñ��˶�ȡ���ݵ�׼��
		while(buff.hasRemaining()){
			System.out.print((char)buff.get());
		}
	}
}
