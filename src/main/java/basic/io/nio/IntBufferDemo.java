package basic.io.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
	private static final int BSIZE=1024;
	public static void main(String[] args) {
		ByteBuffer bb=ByteBuffer.allocate(BSIZE);
		IntBuffer ib=bb.asIntBuffer();
		System.out.println(ib.capacity()); //����256����Ϊһ��int����ռ4���ֽڣ�1024���ֽ�����Ϊ256��int����
		ib.put(new int[]{11,43,47,99,143,811,1016,1212});
		System.out.println(ib.capacity()+"(");
		System.out.println(ib.get(3));
		ib.put(3,181);
		ib.put(new int[]{21,21,4,4});
		ib.flip();
		while(ib.hasRemaining()){
			int i=ib.get();
			System.out.println(i);
		}
	}
}
