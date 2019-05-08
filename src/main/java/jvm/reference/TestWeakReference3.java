package jvm.reference;

import java.lang.ref.WeakReference;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-05-08
 * @modified By yangqc
 */
public class TestWeakReference3 {

    static class Entry extends WeakReference<Integer> {
        /**
         * The value associated with this ThreadLocal.
         */
        Object value;

        Entry(Integer k, Object v) {
            super(k);
            value = v;
        }
    }

    public static void main(String[] args) {
        Entry entry = new Entry(new Integer(1), new Object());
        while (true) {
            System.out.println("key:" + entry.get());
            System.out.println("value:" + entry.value);
        }
    }
}
