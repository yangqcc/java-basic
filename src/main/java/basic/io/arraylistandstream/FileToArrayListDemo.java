package basic.io.arraylistandstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * ���ı��ļ��ж�ȡ���ݵ������У����ұ�������
 * 
 * ����Դ:b.txt---BufferedReader
 * 
 * Ŀ�ĵ�ArrayList
 */
public class FileToArrayListDemo {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("b.txt"));
		ArrayList<String> array=new ArrayList<String>();
		String line=null;
		while((line=br.readLine())!=null)
			array.add(line);
		br.close();
		for(String s:array)
			System.out.println(s);
	}
}
