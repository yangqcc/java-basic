package basic.io.ArrayListAndStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * ���󣬰�ArrayList�����е��ַ����洢���ı��ļ���
 * 
 * ������
 *    ͨ����Ŀ����˼���ǿ���֪������һЩ����
 *    ArrayLisr���ϴ洢���ַ���
 *    
 *    ����Դ��
 *    ArrayList�����õ�ÿһ���ַ�������
 *    
 *    BufferedWriter
 */
public class ArrayListToFileDemo {
	public static void main(String[] args) throws IOException {
		ArrayList<String> array=new ArrayList<String>();
		array.add("hello");
		array.add("world");
		array.add("java");
		//��װĿ�ĵ�
		BufferedWriter bw=new BufferedWriter(new FileWriter("a.txt"));
		for(String s:array){
			bw.write(s);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
}
