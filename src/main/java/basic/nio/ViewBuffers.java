package basic.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/**
 * ����������ͼ
 * 
 * @author yangqc 2016/1/21
 */
public class ViewBuffers {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer
				.wrap(new byte[] { 0, 0, 0, 0, 0, 0, 0, 'a' });
		bb.rewind(); // ���ƻ���������λ�ñ��Ϊ�㣬���������  rewind�᷵��һ��Buffer ��Buffer������
		//��ͼ�Լ�ByteBuffer�ĳ���
		System.out.println("Byte Buffer");
		while (bb.hasRemaining())  //��֪��ǰλ�ú�����֮���Ƿ���Ԫ��
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
