package basic.io.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * �ӱ�׼���������룬ת���ɴ�д��ĸ���ٴӱ�׼��������
 * @author yangqc
 * 2016/6/1
 */
public class ToUpperChar {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null && s.length()!=0){
			System.out.println(s.toUpperCase());
		}
	}
}
