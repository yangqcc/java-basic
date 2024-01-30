package basic.collection.testList;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ���ϵı��� ���λ�ȡ���ϵ�Ԫ�� Object[] toArray  �Ѽ���ת�����飬��ʵ�ּ��ϱ��� 2015.10.8
 */
public class CollectionDemo2 {

  public static void main(String[] args) {
    Collection<String> c = new ArrayList<>();
    c.add("hello");
    c.add("world");
    c.add("java");
    Object[] objs = c.toArray();
    for (Object obj : objs) {
//			System.out.println(objs[x]);
      //֪��Ԫ�����ַ�������ȡԪ�ص�ͬʱ������֪��Ԫ�صĳ���
      //Ҫ��ʹ���ַ����ķ������ͱ����Ԫ�ػ�ԭ���ַ���
      String s = (String) obj;
      System.out.println(s + "-----" + s.length());
    }
  }
}
