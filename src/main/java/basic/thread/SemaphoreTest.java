package basic.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

  private static final Semaphore semaphore = new Semaphore(2);

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(new PrintNumRunnable());
      thread.start();
    }
  }

  public static final class PrintNumRunnable implements Runnable {

    @Override
    public void run() {
      try {
        semaphore.acquire();
        System.out.println("hello_" + Thread.currentThread().getName());
        Thread.sleep(1000);
        semaphore.release();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

}
