package basic.collection.test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ���ϵı���
 * ���λ�ȡ���ϵ�Ԫ��
 * Object[] toArray  �Ѽ���ת�����飬��ʵ�ּ��ϱ���
 * 2015.10.8
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("hello");
        c.add("world");
        c.add("java");
        Object[] objs = c.toArray();
        for (int x = 0; x < objs.length; x++) {
//			System.out.println(objs[x]);
            //֪��Ԫ�����ַ�������ȡԪ�ص�ͬʱ������֪��Ԫ�صĳ���
            //Ҫ��ʹ���ַ����ķ������ͱ����Ԫ�ػ�ԭ���ַ���
            String s = (String) objs[x];
            System.out.println(s + "-----" + s.length());
        }
    }
}
