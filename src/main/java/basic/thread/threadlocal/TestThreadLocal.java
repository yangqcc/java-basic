package basic.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal����һ��ThreadLocalMap,ThreadLocalMap�������һ���������,
 * ������Entry(key,value),����Entry�е�key���ǵ�ǰThreadLocal����,�ڵ�һ��ִ��set����
 * ����get()����ʱ,���ThreadLocalMap��ֵ��Thread����
 * <p>
 * public T get() {
 * Thread t = Thread.currentThread();
 * ThreadLocalMap map = getMap(t);
 * if (map !=null) {
 * ThreadLocalMap.Entry e = map.getEntry(this);
 * if (e != null) {
 *
 * @author yangqc
 * @SuppressWarnings("unchecked") T result = (T)e.value; return result;
 * }
 * }
 * return
 * setInitialValue();
 * }
 * <p>
 * <p>
 * private T setInitialValue() {
 * T value = initialValue();
 * Thread t = Thread.currentThread();
 * ThreadLocalMap map = getMap(t);
 * if (map != null)
 * map.set(this, value); else createMap(t, value);
 * return value;
 * }
 */
public class TestThreadLocal {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new MyTask(1));
        exec.execute(new MyTask(2));
        exec.execute(new MyTask(3));
        exec.execute(new MyTask(4));
    }
}

class MyTask implements Runnable {

    private ThreadLocal<Integer> currentValue;

    MyTask(final int initValue) {
        currentValue = ThreadLocal.withInitial(() -> initValue);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + " : " + currentValue.get());
            currentValue.set(currentValue.get() + 1);
        }
    }
}