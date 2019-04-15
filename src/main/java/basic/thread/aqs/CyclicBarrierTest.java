package basic.thread.aqs;

import java.util.concurrent.*;

/**
 * <p>title:循环栅栏</p>
 * <p>description:
 * CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障（Barrier）。它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。CyclicBarrier默认的构造方法是 CyclicBarrier(int parties)，
 * 其参数表示屏障拦截的线程数量，每个线程调用await方法告诉 CyclicBarrier 我已经到达了屏障，然后当前线程被阻塞。
 * <p>
 * <p>
 * CyclicBarrier 的应用场景
 * <p>
 * CyclicBarrier 可以用于多线程计算数据，最后合并计算结果的应用场景。比如我们用一个Excel保存了用户所有银行流水， 每个Sheet保存一个帐户近一年的每笔银行流水，现在需要统计用户的日均银行流水，
 * 先用多线程处理每个sheet里的银行流水，都执行完之后，得到每个sheet的日均银行流水，最后，再用barrierAction用这些线程的计算结果，计算出整个Excel的日均银行流水。
 * </p>
 *
 * @author yangqc
 * @date Created in 2019-04-13
 * @modified By yangqc
 */
public class CyclicBarrierTest {

    private static final int threadCount = 550;

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        test2();
    }

    public static void test1() {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            es.submit(() -> {
                System.out.println(threadNum + ",准备!");
                try {
                    cyclicBarrier.await(60, TimeUnit.SECONDS);
                    System.out.println(threadNum + ",结束!");
                } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                    e.printStackTrace();
                }
            });
        }
        es.shutdown();
    }

    public static void test2() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () ->
        {
            try {
                Thread.sleep(1000);
                System.out.println("线程到达数量后，优先执行!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        ExecutorService ex = Executors.newCachedThreadPool();

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            ex.submit(() -> {
                System.out.println(threadNum + ",开始等待!");
                try {
                    cyclicBarrier.await();
                    System.out.println(threadNum + ",结束!");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        ex.shutdown();
    }
}
