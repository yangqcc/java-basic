package basic.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangqc
 */
public class TestThreadPool1 {

  private volatile static int i = 0;

  public static void main(String[] args) {
    Runnable task = () -> {
      while (true) {
        try {
          if (Thread.interrupted()) {
            System.out.println("interrupted!");
          }
          if (i++ == 10000) {
            break;
          }
          Thread.sleep(1000);
          System.out.println("xixi");
        } catch (InterruptedException e) {
          System.out.println("异常");
        }
      }
    };

    /**
     * 最好手动创建线程池
     */
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(task);
    exec.shutdown();
  }
}