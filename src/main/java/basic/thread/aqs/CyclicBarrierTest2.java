package basic.thread.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>title: 人满发车</p>
 * <p>description:每二十个人一班车</p>
 *
 * @author yangqc
 * @date Created in 2019-04-15
 * @modified By yangqc
 */
public class CyclicBarrierTest2 {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(20, () -> System.out.println("hello,发车咯!"));
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Thread.sleep(1000);
            executorService.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ",等着发车!");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

