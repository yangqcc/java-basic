package basic.io.ioTest;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {
	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(new BufferedInputStream((new FileInputStream("src/com/yqc/ioTest/TestEOF.java"))));
		while (in.available() != 0)
			// ��Ϊ '\n'Ҳ��һ���ַ�������ֻ����available�ж��Ƿ�����յ�,��ʾû������������¶�ȡ���ֽ���
			System.out.println((char) in.readByte());
	}
}
