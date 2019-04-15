package basic.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * ��ȡ��������
 *
 * @author yangqc 2016.6.2
 */
public class GetData {

  private static final int BSIZE = 1024;

  public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.allocate(BSIZE);  //�����ֽ���
    int i = 0;
    while (i++ < bb.limit()) //�ж���ʼÿλ�Ƿ�Ϊ0
    {
      if (bb.get() != 0) {
        System.out.println("nonzero");
      }
    }
    System.out.println("i=" + i);
    bb.rewind();
    bb.asCharBuffer().put("Howdy!");
    char c;
    bb.rewind();
    while ((c = bb.getChar()) != 0) {
      System.out.print(c + " ");
    }
//		System.out.println(bb.position());
//		bb.rewind();
    CharBuffer cb = ((ByteBuffer) bb.rewind()).asCharBuffer();
    System.out.println(cb.remaining());
    for (int j = 0; j < cb.remaining(); j++) {
      cb.put(j, 'a');
      System.out.println(bb);
    }
    while (cb.hasRemaining()) {
      System.out.print((char) cb.get());
    }
//		System.out.println(bb.position());
    System.out.println();
    bb.rewind();
    bb.asShortBuffer().put((short) -32769);
    System.out.println(bb.getShort());
    bb.rewind();
    bb.asIntBuffer().put(89798798);
    System.out.println(bb.getInt());
    bb.rewind();
    bb.asLongBuffer().put(9809L);
    System.out.println(bb.getLong());
    bb.rewind();
    bb.asFloatBuffer().put(9879798f);
    bb.rewind();
    bb.asDoubleBuffer().put(2112);
    System.out.println(bb.getDouble());
    bb.rewind();
  }
}
