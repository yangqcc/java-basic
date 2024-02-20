package basic.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author yangqc
 */
public class BufferToNext {

  private static final int BSIZE = 1024;

  public static void main(String[] args) throws IOException {
    FileChannel fc = new FileOutputStream("data2.txt").getChannel();
    fc.write(ByteBuffer.wrap("Some text".getBytes()));
    fc = new FileInputStream("data2.txt").getChannel();
    ByteBuffer buff = ByteBuffer.allocate(BSIZE);
    fc.read(buff);
    buff.flip();
    System.out.println(buff.asCharBuffer());
    buff.rewind();
    String encoding = System.getProperty("file.encoding");
    System.out.println("Decoded using " + encoding + ": "
        + Charset.forName(encoding).decode(buff));
    fc = new FileOutputStream("data2.txt").getChannel();
    fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-8")));
    fc.close();
    fc = new FileInputStream("data2.txt").getChannel();
    buff.clear();
    fc.read(buff);
    buff.flip();
    System.out.println(buff.asCharBuffer());
    fc = new FileOutputStream("data2.txt").getChannel();
    buff = ByteBuffer.allocate(24);
    buff.asCharBuffer().put("Some text");
    fc.write(buff);
    fc.close();
    fc = new FileInputStream("data2.txt").getChannel();
    buff.clear();
    fc.read(buff);
    buff.flip();
    System.out.println(buff.asCharBuffer());
  }
}
