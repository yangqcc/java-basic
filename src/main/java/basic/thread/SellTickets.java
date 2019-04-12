package basic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 卖票任务
 *
 * @author yangqc
 */
public class SellTickets implements Runnable {

  private static volatile int TICKET_NUM = 1000;
  private static final Lock lock = new ReentrantLock();
  private static final Condition condition = lock.newCondition();

  @Override
  public void run() {
    lock.lock();
    try {
      while (TICKET_NUM > 0) {
        System.out.println(Thread.currentThread().getName() + " * " + --TICKET_NUM);
        condition.signalAll();
        condition.await();
      }
      condition.signalAll();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    SellTickets task = new SellTickets();
    for (int i = 0; i < 10; i++) {
      new Thread(task).start();
    }
  }

}
