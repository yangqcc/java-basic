package basic.thread.lock;

/**
 * 自定义自旋锁
 *
 * @author yangqc
 */
public class MyLock {

  private volatile boolean flag = false;

  private Thread currentThread;

  public synchronized void lock() throws InterruptedException {

    while (flag) {
      wait();
    }
  }
}
