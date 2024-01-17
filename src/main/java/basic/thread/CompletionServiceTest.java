package basic.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceTest {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService executor = Executors.newFixedThreadPool(3);
    CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);
    completionService.submit(new getPrice1());
    completionService.submit(new getPrice2());
    completionService.submit(new getPrice3());

    for (int i = 0; i < 3; i++) {
      Future<Integer> take = completionService.take();
      System.out.println(take.get());
    }
    System.out.println("hello!");
    executor.shutdown();
  }

  private static class getPrice1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
      Thread.sleep(1000);
      return 10;
    }
  }

  private static class getPrice2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
      Thread.sleep(5000);
      return 20;
    }
  }

  private static class getPrice3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
      Thread.sleep(10000);
      return 30;
    }
  }
}
