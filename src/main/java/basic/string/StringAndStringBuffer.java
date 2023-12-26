package basic.string;
/*
 * String��StringBuffer���໥ת��
 * Aת��ΪB��ʵ��Ϊ��ʹ��B�Ĺ���
 * �����Ҫʹ��A�����ͣ����Ի�Ҫת����
 */
public class StringAndStringBuffer {
	public static void main(String[] args) {
		String s="hello";
		//����ֱ�Ӱ��ַ�����ֵ��ֵ��StringBuffer
//		StringBuffer sb=s;
		//���������ֽ�Stringת��StringBuffer�ķ���:
		StringBuffer sb=new StringBuffer(s);
		StringBuffer sb2=new StringBuffer();
		sb2.append(s);
		
		
		System.out.println("sb:"+sb);
		System.out.println("sb2:"+sb2);
		StringBuffer buffer=new StringBuffer("java");
		//String(StringBuffer buffer)
		//1.���췽��
		String str=new String(buffer);
		//2.ͨ��toString����
		String str2=buffer.toString();
		System.out.println("str:"+str);
		System.out.println("str2:"+str2);
	}
}
