package basic.collection.testList;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 1.void add(int index,Object element)���ƶ�λ�����Ԫ�� 2.int indexOf(Object o)���ص�һ�γ��ֵ��ƶ�Ԫ�ص�������������б��������򷵻�-1
 * <p>
 * �б������ 3.ListIterator listIterator() List�������еĵ����� 4.ListIterator listIterator(int index) ��ָ��λ�ÿ�ʼ����
 * <p>
 * E previous ������һ��Ԫ��  ***��������Ҫע������λ�ã�Ҫ��������Ҫ��������һ��ʹ�ã�ûʲô���� boolean hasPrevious �����������
 * <p>
 * 5.�޸Ĺ��� Object set(int index,Object element) ���������޸�Ԫ�� �����޸ĵ�Ԫ�� 2015.10.9
 */
public class ListDemo1 {

  public static void main(String[] args) {
    //�������϶���
    List<String> list = new ArrayList<>();
    list.add("hello");
    list.add("world");
    list.add("java");
    list.add(1, "android");
    list.add(3, "javaee");
    //�õ������̳���Iterator�����������Կ���ֱ��ʹ��hasNext��next����
    ListIterator<String> lit = list.listIterator();//�����������
    while (lit.hasNext()) {
      String s = lit.next();
      System.out.println(s);
    }
    System.out.println(lit.previous() + "****");
    for (String s : list) {
      System.out.println(s);
    }
    System.out.println("list:" + list);
  }
}
