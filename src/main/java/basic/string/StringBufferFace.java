package basic.string;
/*
 * 1.String,StringBuilder,StringBuffer
 *   A:String�����ݲ��ɱ�ģ���StringBuffer��StringBuilder�������ݿɱ��
 *   B:StringBuffer��ͬ���ģ����ݰ�ȫ��Ч�ʵͣ�StringBuilder�ǲ�ͬ���ģ����ݲ���ȫ��Ч�ʸ�
 * 2.StringBuffer�����������
 *   ���߶����Կ���һ��������װ��������
 *   A:StringBuffer��������κ����ͣ��������ն���Ϊ�Ը���
 *   B:����ֻ�ܴ���������͵�ͬһ�����ݣ���������ͬһ����������
 * 3.��ʽ��������
 *   A:String��Ϊ��������
 *   B:StringBuffer��Ϊ��������
 *   
 * ��ʽ����:
 *   ��������:��ʽ�����ĸı䲻Ӱ��ʵ�ʲ���
 *   ��������:��ʽ�����ĸı�ֱ��Ӱ��ʵ�ʲ���
 *   
 * ע��:
 *   String��Ϊ�βΣ�Ч���ͻ���������һ����
 */
public class StringBufferFace {
	public static void main(String[] args) {
		String s1="hello";
		String s2="world";
		System.out.println(s1+"---"+s2);
		change(s1,s2);
		System.out.println(s1+"---"+s2);
		StringBuffer sb1=new StringBuffer("hello");
		StringBuffer sb2=new StringBuffer("world");
		System.out.println(sb1+"---"+sb2);
		change(sb1,sb2);
		System.out.println(sb1+"---"+sb2);
	}
	private static void change(StringBuffer sb1,StringBuffer sb2){
		sb1=sb2;
		sb2.append(sb1);
	}
	private static void change(String s1, String s2) {
		s1=s2;
		s2=s1+s2;
	}
}
