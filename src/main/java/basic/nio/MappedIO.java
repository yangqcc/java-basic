package basic.nio;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class MappedIO {

  private static int numOfInts = 4000000;
  private static int numOfUbuffInts = 200000;

  private abstract static class Testter {

    private String name;

    public Testter(String name) {
      this.name = name;
    }

    public void runTest() {
      try {
        long start = System.nanoTime();
        test();
        double duration = System.nanoTime() - start;
        System.out.format("%.2f\n", duration / 1.0e9);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public abstract void test() throws IOException;
  }

  private static Testter[] tests = {
      new Testter("Stream Write") {
        @Override
        public void test() throws IOException {
          DataOutputStream dos = new DataOutputStream(
              new BufferedOutputStream(new FileOutputStream(new File("temp.tmp"))));
          for (int i = 0; i < numOfInts; i++) {
            dos.writeInt(1);
          }
          dos.close();
        }
      },
      new Testter("Mapped Writer") {
        @Override
        public void test() throws IOException {
          FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
          IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
          for (int i = 0; i < numOfInts; i++) {
            ib.put(i);
          }
          fc.close();
        }
      }
  };
}
