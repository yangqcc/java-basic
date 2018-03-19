package basic.string;
/*
 * StringBuffer��ɾ������
 *   public StringBuffer deleteCharAt(int index)  ɾ��ָ��λ�õ��ַ������ر���
 *   public StirngBuffer delete(int start,int end)  ɾ����ָ��λ�ÿ�ʼ��ָ��λ�ý������ַ���
 */
public class StringBufferDelete {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		sb.append("hello").append("world").append("java");
		System.out.println("sb:"+sb);
		//����ɾ��e����ַ�
//		sb.deleteCharAt(1);
//		System.out.println("sb:"+sb);
//		//ɾ����һ��l
//		sb.deleteCharAt(1);//ע�⣬������1
//		System.out.println("sb:"+sb);
		//public StirngBuffer delete(int start,int end)  ɾ����ָ��λ�ÿ�ʼ��ָ��λ�ý������ַ���
		//ɾ��world����ַ���
//		sb.delete(5, 10);
//		System.out.println("sb:"+sb);
		//ɾ����������
		sb.delete(0, sb.length());
		System.out.println("sb:"+sb);
	}
}
