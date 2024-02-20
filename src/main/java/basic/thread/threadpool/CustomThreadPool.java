package basic.thread.threadpool;

import java.util.concurrent.*;

/**
 * <p>title:</p>
 * <p>description:
 *
 *
 * </p>
 *
 * @author yangqc
 * @date Created in 2019-05-08
 * @modified By yangqc
 */
public class CustomThreadPool {
    public static void main(String[] args) {
        /**
         * 这里核心线程池为0，先把任务放在队列里面，然后再去判断线程池是否关闭，如果没有关闭，那么则再去判断
         * 当前运行线程池数量是否为空，如果为空，那么新建一个worker，当前worker的firstTask为空，worker运行起来后，
         * 还是会去阻塞队列里面获取任务，获取到任务后就执行该任务
         */
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 5, 60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), new CustomThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        ExecutorService executorService1 = Executors.newCachedThreadPool();

    }

}
