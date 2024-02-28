package basic.thread;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(1);
    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        try {
          latch.await();
          System.out.println("你好,我等到了!");
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }).start();
    }
    Thread.sleep(2000);
    System.out.println("睡醒了!");
    latch.countDown();
  }

}
