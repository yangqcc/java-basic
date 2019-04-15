package basic.io.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * @author yangqc
 */
public class Endians {

  public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
    bb.asCharBuffer().put("abcdef");  //ÿ��charռ�����ֽ�
    System.out.println(Arrays.toString(bb.array()));
    bb.rewind();
    bb.order(ByteOrder.BIG_ENDIAN);  //��λ���ȣ���Ҫ���ֽڷ��ڵ�λ
    bb.asCharBuffer().put("abcdef");
    System.out.println(Arrays.toString(bb.array()));
    bb.rewind();
    bb.order(ByteOrder.LITTLE_ENDIAN);
    bb.asCharBuffer().put("abcdef");  //��λ���ȣ���Ҫ���ֽڷ��ڸ�λ
    System.out.println(Arrays.toString(bb.array()));
  }
}
