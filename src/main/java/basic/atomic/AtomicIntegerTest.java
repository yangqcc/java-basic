package basic.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>title:AtomicInteger 原子类用法</p>
 * <p>description:
 * AtomicInteger源码：
 * <p>
 * //Unsafe类 private static final Unsafe unsafe = Unsafe.getUnsafe();
 * <p>
 * //值的偏移量 private static final long valueOffset;
 * <p>
 * static { try { valueOffset = unsafe.objectFieldOffset (AtomicInteger.class.getDeclaredField("value"));
 * } catch (Exception ex) { throw new Error(ex); } }
 * <p>
 * //用volatile来保证值的可见性 private volatile int value;
 *
 * </p>
 *
 * @author yangqc
 * @date Created in 2019-04-12
 * @modified By yangqc
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {
        int itemValue = 0;
        AtomicInteger i = new AtomicInteger(0);
        itemValue = i.getAndSet(3);
        System.out.println("itemValue:" + itemValue + ";i:" + i);
        itemValue = i.getAndIncrement();
        System.out.println("itemValue:" + itemValue + "; i:" + i);
        itemValue = i.getAndAdd(5);
        System.out.println("itemValue:" + itemValue + ";i:" + i);
    }

    /////多线程环境不使用原子类来保证线程安全//////

    private volatile int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    private AtomicInteger count2 = new AtomicInteger();

    public void increment2() {
        count2.getAndIncrement();
    }

    public int getCount2() {
        return count2.get();
    }
}
