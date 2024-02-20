package basic.thread.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>title:CountDownLatch测试</p>
 * <p>description:
 * ①某一线程在开始运行前等待n个线程执行完毕。将 CountDownLatch 的计数器初始化为n ：new CountDownLatch(n) ，每当一个任务线程执行完毕，就将计数器减1
 * CountDownLatch.countDown()，当计数器的值变为0时，在CountDownLatch上 await() 的线程就会被唤醒。
 * 一个典型应用场景就是启动一个服务时，主线程需要等待多个组件加载完毕，之后再继续执行。
 * <p>
 * ②实现多个线程开始执行任务的最大并行性。注意是并行性，不是并发，强调的是多个线程在某一时刻同时开始执行。
 * 类似于赛跑，将多个线程放到起点，等待发令枪响，然后同时开跑。做法是初始化一个共享的
 * CountDownLatch 对象，将其计数器初始化为 1 ：new CountDownLatch(1) ，多个线程在开始执行任务前首先 CountDownLatch.await()，当主线程调用
 * countDown() 时，计数器变为0，多个线程同时被唤醒。
 * <p>
 * ③死锁检测：一个非常方便的使用场景是，你可以使用n个线程访问共享资源，在每次测试阶段的线程数目是不同的，并尝试产生死锁。
 * </p>
 * <p>
 * CountDownLatch的不足： CountDownLatch是一次性的，计数器的值只能在构造方法中初始化一次，之后没有任何机制再次对其设置值，
 * 当CountDownLatch使用完毕后，它不能再次被使用。
 *
 * @author yangqc
 * @date Created in 2019-04-13
 * @modified By yangqc
 */
public class CountDownLatchTest {

    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    /**
     * 第一种用法，多个线程先运行，运行到某一节点，唤醒另外一个线程
     */
    public static void test() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(200);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            es.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("threadNum:" + threadNum);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                    System.out.println("嘻嘻!");
                }
            });
        }
        countDownLatch.await();
        es.shutdown();
        System.out.println("finish");

    }

    /**
     * 第二个用法，多个线程先等待，然后同时出发，并发执行
     */
    public static void test2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService es = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            es.submit(new Task(countDownLatch));
        }
        System.out.println("等老大睡醒!");
        Thread.sleep(1000);
        System.out.println("老大睡醒了!");
        countDownLatch.countDown();
    }
}

class Task implements Runnable {

    private final CountDownLatch countDownLatch;

    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + ",出发咯!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
