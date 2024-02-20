package basic.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer�Ǵ�ByteBuffer�̳ж���
 *
 * @author yangqc 2016.6.2 ���ļ������������ڵײ�����ܴ���ļ�
 */
public class LargeMappedFiles {

  static int length = 0x8FFFFFF; //128MB

  public static void main(String[] args) throws FileNotFoundException, IOException {
    MappedByteBuffer out = new RandomAccessFile("text.dat", "rw").getChannel()
        .map(FileChannel.MapMode.READ_WRITE, 0, length);//����ζ�ſ���ӳ����ļ���С�Ĳ���
    for (int i = 0; i < length; i++) {
      out.put((byte) 'x');
    }
    for (int i = length / 2; i < length / 2 + 6; i++) {
      System.out.println((char) out.get(i));
    }
  }
}
