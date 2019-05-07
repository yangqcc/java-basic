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
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        exec.execute(() -> new MyTask(1, threadLocal).run());
        exec.execute(() -> new MyTask(2, threadLocal).run());
        exec.execute(() -> new MyTask(3, threadLocal).run());
        exec.execute(() -> new MyTask(4, threadLocal).run());
    }
}

class MyTask {

    private ThreadLocal<Integer> currentValue;

    /**
     * 如果没有调用set()方法，然后就调用了get()方法，那么这个作为初始化值,
     *
     * @param initValue
     */
    MyTask(final int initValue, ThreadLocal<Integer> threadLocal) {
        currentValue = threadLocal;
        //调用set()方法,那么则不会再去调用withInitial()方法获取默认值
        threadLocal.set(initValue);
    }

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