package basic.collection.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator iterator ������������ר�ñ�����ʽ
 * <p>
 * E next() ��ȡԪ�أ�������һ��Ԫ��
 * NoSuchElementException;û��������Ԫ��
 * <p>
 * boolean hasNext() �Ƿ�����һ��Ԫ��
 * 2015.10.8
 */
public class CollectionIterator {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("hello");
        c.add("world");
        c.add("java");
        //Iterator iterator
        Iterator it = c.iterator();//ʵ�ʷ��ص���������󣨶�̬��
        while (it.hasNext()) {
            System.out.println(it.next());//��ȡԪ�ز��ƶ�����һ��λ��
        }

    }
}
