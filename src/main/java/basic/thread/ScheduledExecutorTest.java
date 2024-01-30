package basic.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    Callable<Long> task1 = new CallableTask();
    Callable<Long> task2 = new CallableTask();
    Callable<Long> task3 = new CallableTask();
    ScheduledFuture<Long> future1 = executor.schedule(task1, 0, TimeUnit.MILLISECONDS);
    ScheduledFuture<Long> future2 = executor.schedule(task2, future1.get(), TimeUnit.MILLISECONDS);
    ScheduledFuture<Long> future3 = executor.schedule(task3, future2.get(), TimeUnit.MILLISECONDS);
    System.out.println(future3.get());
// 任务会按照依赖关系和前一个任务的执行时间逐个执行
    executor.shutdown();
  }

  public static final class CallableTask implements Callable<Long> {

    @Override
    public Long call() throws Exception {
      System.out.println(Thread.currentThread().getName());
      return 10L;
    }
  }
}
