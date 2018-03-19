package basic.string;
/*
 * �̰߳�ȫ
 * ��ȫ----ͬ��---�����ǰ�ȫ�ģ�����ȡǮ��
 * ����ȫ----��ͬ��---Ч�ʸ�һЩ
 * ��ȫ��Ч����������Զ�������ǵ�
 * ��ȫ��ҽԺ����վ��������վ
 * Ч�ʣ�������վ����̳֮��
 * 
 * StringBuffer���췽��
 *    public StringBuffer();�޲ι��캯��
 *    public StringBuffer(int capacity)ָ���������ַ�������������
 *    public StringBuffer(String str);ָ���ַ������ݵĻ���������
 *    
 * StringBuffer�ķ���:
 *      public int capacity();���ص�ǰ����
 *      public int length()���س��ȣ��ַ�����,ʵ��ֵ
 */
public class StringBufferDemo1 {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();//һ�������
		System.out.println("sb:"+sb);
		System.out.println("sb:"+sb.capacity());
		System.out.println("sb:"+sb.length());
		//ָ���������ַ���������
		StringBuffer sb2=new StringBuffer(50);
		System.out.println("sb:"+sb2);
		System.out.println("sb:"+sb2.capacity());
		System.out.println("sb:"+sb2.length());
		//public StringBuffer(String str);ָ���ַ������ݵĻ���������
		StringBuffer sb3=new StringBuffer("hello");
		System.out.println("sb:"+sb3);
		System.out.println("sb:"+sb3.capacity());
		System.out.println("sb:"+sb3.length());
	}
}
