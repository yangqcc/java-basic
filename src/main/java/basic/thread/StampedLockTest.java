package basic.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

  private static int x, y;
  private static final StampedLock sl = new StampedLock();

  public static void main(String[] args) throws InterruptedException {
    new Thread(() -> {
      try {
        double v = distanceFromOrigin();
        System.out.println(v);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }).start();
    new Thread(new getVarRunnable()).start();
    new Thread(() -> {
      try {
        double v = distanceFromOrigin();
        System.out.println(v);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }).start();
    long readLock = sl.readLock();
    long l = sl.tryConvertToWriteLock(readLock);

  }

  static final class getVarRunnable implements Runnable {

    @Override
    public void run() {
      Lock writeLock = sl.asWriteLock();
      try {
        Thread.sleep(1000);
        writeLock.lock();
        x = 10;
        y = 10;
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        writeLock.unlock();
      }

    }
  }

  // 计算到原点的距离
  private static double distanceFromOrigin() throws InterruptedException {
    // 乐观读
    long stamp = sl.tryOptimisticRead();
    // 读入局部变量，
    // 读的过程数据可能被修改
    int curX = x, curY = y;
    Thread.sleep(2000);
    // 判断执行读操作期间，
    // 是否存在写操作，如果存在，
    // 则 sl.validate 返回 false
    if (!sl.validate(stamp)) {
      // 升级为悲观读锁
      stamp = sl.readLock();
      System.out.println("upgrade lock!");
      try {
        curX = x;
        curY = y;
      } finally {
        // 释放悲观读锁
        sl.unlockRead(stamp);
      }
    }
    return Math.sqrt(curX * curX + curY * curY);
  }
}
