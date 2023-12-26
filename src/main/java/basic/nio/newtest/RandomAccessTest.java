package basic.nio.newtest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * java nio
 * 2018/3/23
 */
public class RandomAccessTest {

    public static void method1() {
        RandomAccessFile aFile = null;
        try {
            File file = new File(RandomAccessTest.class.getResource("/test.txt").getPath());
            aFile = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = aFile.getChannel();
            //分配空间
            ByteBuffer buf = ByteBuffer.allocate(1024);
            // 从channel读取到buffer
            // Reads a sequence of bytes from this channel into the given buffer.
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);
            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        method1();
    }
}
