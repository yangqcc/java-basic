package basic.collection.map;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/**
 * ����:����Ĳ�ͬ�����޸�����ʱ�����ܻᵼ������״̬��һ�£����Իᱨ��
 *
 * @author yangqc
 * <p>
 * 2016-6-15
 */
public class FailFast {
    public static void main(String[] args) {
        List<String> c = new ArrayList<>();
        c.add("An Object");
        System.out.println(c.size());
        Iterator<String> it = c.iterator();
        c.remove(0);
        c.add(0, "123");
        System.out.println(c.size());
        try {
            String s = it.next();
        } catch (ConcurrentModificationException e) {
            System.out.println(e);
        }
    }
}
