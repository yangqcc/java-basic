package basic.thread.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-04-13
 * @modified By yangqc
 */
public class SemaphoreTest {

  /**
   * 银行类
   */
  class Bank {

    private final AtomicInteger atomicInteger;

    public Bank(int initAccount) {
      if (initAccount >= 0) {
        atomicInteger = new AtomicInteger(initAccount);
      } else {
        throw new IllegalArgumentException("初始化金额不能小于0");
      }
    }

    public int getAccount() {
      return atomicInteger.get();
    }

    public void save(int account) {
      atomicInteger.getAndAdd(account);
    }
  }

  class NewThread implements Runnable {

    private Bank bank;

    private Semaphore semaphore;

    public NewThread(Bank bank, Semaphore semaphore) {
      this.bank = bank;
      this.semaphore = semaphore;
    }

    @Override
    public void run() {
      String threadName = Thread.currentThread().getName();
      if (semaphore.availablePermits() > 0) {
        System.out.println("线程'" + threadName + "'启动，进入银行，有位置去存钱");
      } else {
        System.out.println("线程'" + threadName + "'启动，进入银行，无位置，去排队等待");
      }
      try {
        semaphore.acquire();
        bank.save(10);
        System.out.println(threadName + "存入10元钱,账户余额为:" + bank.getAccount());
        Thread.sleep(1000);
        System.out.println("线程'" + threadName + "'存钱完毕，离开银行!");
        semaphore.release();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void useThread() {
    Bank bank = new Bank(0);
    Semaphore semaphore = new Semaphore(2);
    ExecutorService es = Executors.newCachedThreadPool();
    for (int i = 0; i < 10; i++) {
      es.submit(new NewThread(bank, semaphore));
    }
    es.shutdown();
    semaphore.acquireUninterruptibly(2);
    System.out.println("到点了，工作人员要吃饭了!");
    //释放两个许可，并将其返回信号量
    semaphore.release(2);
    System.out.println("饭吃完了!");
  }

  public static void main(String[] args) {
    SemaphoreTest thread = new SemaphoreTest();
    thread.useThread();
  }

}
