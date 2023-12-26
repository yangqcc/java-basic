package basic.nio.newtest;

import java.io.*;
import java.nio.channels.FileChannel;

public class MappedByteBuffer {
    public static void main(String[] args) throws IOException {
//        method3();
        method4();
    }

    public static void method4() throws IOException {
        //源文件
        File file = new File("src/test.csv");
        //这里要统一编码
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), "gbk");
        BufferedReader bfr = new BufferedReader(read);
        String line = null;
        while ((line = bfr.readLine()) != null) {
            String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
            for (String str : item)
                if (null != str && !str.equals(""))
                    System.out.print(str + " , ");
            System.out.println("\n---------------");
        }
    }

    public static void method3() {
        RandomAccessFile aFile = null;
        FileChannel fc = null;
        try {
            aFile = new RandomAccessFile("src/test.csv", "rw");
            fc = aFile.getChannel();
            long timeBegin = System.currentTimeMillis();
            java.nio.MappedByteBuffer map = fc.map(FileChannel.MapMode.READ_ONLY, 0, aFile.length());
            //将存映射放入到变量中进行输出
            byte[] data = new byte[10000];
            int foot = 0;
            byte b;
            while (map.hasRemaining()) {
                while ((b = map.get()) != 10) {
                    System.out.println(b);
                    data[foot++] = b;
                }
                System.out.println(new String(data, "GBK"));
                data = new byte[10000];
                foot = 0;
            }
            long timeEnd = System.currentTimeMillis();
            System.out.println("Read time: " + (timeEnd - timeBegin) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
                if (fc != null) {
                    fc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
