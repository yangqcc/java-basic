package basic.thread.concurrentqueue;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �Զ�����������,jdk1.5֮ǰ�ķ���
 *
 * @author yangqc 2016年12月20日
 */
public class MyArrayListQueue3<T> {

  private Object[] objs;
  private int sum;
  private volatile int count = 0;
  private volatile int putIndex = 0;
  private volatile int getIndex = 0;

  public MyArrayListQueue3(int sum) {
    this.sum = sum;
    objs = new Object[sum];
  }

  public synchronized void put(T t) {
    while (count == sum) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException();
      }
    }
    objs[putIndex] = t;
    if (++putIndex == sum) {
      putIndex = 0;
    }
    count++;
    notifyAll();
    System.out.println("put" + Arrays.toString(objs));
  }

  @SuppressWarnings("all")
  public T get() {
    T t = null;
    while (count == 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    t = (T) objs[getIndex];
    objs[getIndex] = null;
    if (++getIndex == sum) {
      getIndex = 0;
    }
    count--;
    notifyAll();
    System.out.println("get" + Arrays.toString(objs));
    return t;
  }

  public static void main(String[] args) {
    MyArrayListQueue<Integer> queue = new MyArrayListQueue<>(3);
    Runnable putTask = () -> {
      while (true) {
        queue.put(1);
      }
    };
    Runnable getTask = () -> {
      while (true) {
        queue.get();
      }
    };

    ExecutorService exec = Executors.newCachedThreadPool();
    exec.submit(putTask);
    exec.submit(putTask);
    exec.submit(putTask);
    exec.submit(getTask);
    exec.submit(getTask);
    exec.submit(getTask);
  }
}
