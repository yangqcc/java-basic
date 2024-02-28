package basic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

  private static final ReentrantLock lock = new ReentrantLock();
  private static final Condition condition = lock.newCondition();

  private static volatile int i = 2;

  public static void main(String[] args) {
    for (int i = 5; i < 100; i++) {
      new Thread(new MyTask(i)).start();
    }
  }

  private static final class MyTask implements Runnable {

    private final int THIS_NO;

    MyTask(int no) {
      THIS_NO = no;
    }

    @Override
    public void run() {
      try {
        lock.lock();
        while (THIS_NO % i == 0) {
          condition.await();
        }
        i = i + 1;
        System.out.printf("no:%d,i:%d\n", THIS_NO, i);
        condition.signalAll();
      } catch (Exception e) {
        System.out.println(e);
      } finally {
        lock.unlock();
      }
    }
  }

}
