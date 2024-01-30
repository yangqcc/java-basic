package basic.collection.testList;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Iterator iterator ������������ר�ñ�����ʽ
 * <p>
 * E next() ��ȡԪ�أ�������һ��Ԫ�� NoSuchElementException;û��������Ԫ��
 * <p>
 * boolean hasNext() �Ƿ�����һ��Ԫ�� 2015.10.8
 */
public class CollectionIterator {

  public static void main(String[] args) {
    Collection<String> c = new ArrayList<>();
    c.add("hello");
    c.add("world");
    c.add("java");
    //Iterator iterator
    //ʵ�ʷ��ص���������󣨶�̬��
    for (String s : c) {
      System.out.println(s);//��ȡԪ�ز��ƶ�����һ��λ��
    }

  }
}
