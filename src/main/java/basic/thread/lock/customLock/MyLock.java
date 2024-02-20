package basic.thread.lock.customLock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义自旋锁
 *
 * @author yangqc
 */
public class MyLock {

    private volatile Thread currentThread;

    private AtomicInteger count = new AtomicInteger(0);

    public void lock() {
        while (!tryLock()) {
        }
    }

    public synchronized boolean tryLock() {
        if (count.get() > 0) {
            if (currentThread != Thread.currentThread()) {
                return false;
            } else {
                count.getAndIncrement();
                return true;
            }
        } else {
            count.getAndIncrement();
            currentThread = Thread.currentThread();
            return true;
        }
    }


    public synchronized void unlock() {
        if (currentThread == Thread.currentThread()) {
            currentThread = null;
            count.getAndDecrement();
            System.out.println(count.get());
        } else {
            throw new IllegalMonitorStateException("不是当前获取锁线程释放锁!");
        }
    }
}
