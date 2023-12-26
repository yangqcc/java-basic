package basic.string;
/*
 * ��ӹ���
 *    public StringBuffer append(String str) ���԰�����������ӵ��ַ�������������,�������ַ�������������
 *    
 *    public StringBuffer insert(int offset,String str);��ָ��λ�ð��������͵����ݲ�������
 */
public class StringBufferDemoAdd {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		StringBuffer sb2=sb.append("hello");//���ص���������û�����¿��ռ�
		System.out.println("sb:"+sb);
		System.out.println("sb2:"+sb2);
		System.out.println(sb==sb2);
//		sb.append("hello");//��������κζ���
//		sb.append(true);
//		sb.append(12);
//		sb.append(34.56);
		sb.append("hello").append(true).append(12).append(24.56);
		System.out.println("sb:"+sb);
		// public StringBuffer insert(int offset,String str);��ָ��λ�ð��������͵����ݲ�������
		sb.insert(5, "world");
		System.out.println("sb:"+sb);
	}
}
