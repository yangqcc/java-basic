package basic.io.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * ��ʽ�������ڴ�
 *
 * @author yangqc
 */
public class FormattedMemoryInput {

  public static void main(String[] args) throws IOException {
    DataInputStream in = new DataInputStream(
        new ByteArrayInputStream(BufferedInputFile.read("").getBytes()));
    while (true) {
      System.out.println(in.readByte());
    }
  }
}
