package basic.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCyclicBarrier {

  public static void main(String[] args) {
    CyclicBarrier barrier = new CyclicBarrier(10, () -> System.out.println("end!"));
    AtomicInteger atomicInteger = new AtomicInteger(1);
    Runnable myRunnable = () -> {
      try {
        Thread.sleep(500L * atomicInteger.incrementAndGet());
        barrier.await();
        System.out.println(Thread.currentThread().getId());
      } catch (InterruptedException | BrokenBarrierException e) {
        throw new RuntimeException(e);
      }
    };

    for (int i = 0; i < 10; i++) {
      new Thread(myRunnable).start();
    }
  }

}
