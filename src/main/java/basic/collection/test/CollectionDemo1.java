package basic.collection.test;

import java.util.ArrayList;
import java.util.Collection;

/*
 * ��������
 * �����StringBuffer(������ַ�������һ������Ҫ��)
 *
 * ��Բ�ͬ����java�ṩ�˲�ͬ������
 * 2015.10.8
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		//���Բ���All�ķ���
		Collection c=new ArrayList();
		System.out.println("c:"+c);
		//���Դ�All�ķ���
		Collection c1=new ArrayList();
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");
		c1.add("abc5");
		c1.add("abc6");
		Collection c2=new ArrayList();
		c2.add("abc4");
		c2.add("abc6");
		c2.add("abc7");

		//removeAllֻҪ��һ��Ԫ���Ƴ��˾ͷ���All
		//containsAllֻ��ȫ����������Ԫ�زŽа���
		//retainAll����н����򷵻�true,���û�н����򷵻�false
//		System.out.println("removeAll:"+c1.removeAll(c2));
//		System.out.println("c1:"+c1);
//		System.out.println("c2:"+c2);
//		System.out.println("addAll:"+c1.addAll(c2));

		//��������������A��B
		//A��B���������ձ�����A�У�B����
		//����ֵ��ʾA�Ƿ����仯
		System.out.println("c1:"+c1);
		//��ȡ����
		System.out.println("retainAll:"+c1.retainAll(c2));
		System.out.println("c1:"+c1);
	}
}
