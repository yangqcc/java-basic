package basic.thread.callable;

import java.util.concurrent.*;

/**
 * <p>title:Callable和Runnable的区别</p>
 * <p>description:
 * Callable可以抛出异常，并且可以返回值，值通过Future.get()获取
 * 但是Future.get()是阻塞操作，Executors里面有将Runnable转换为Callable的方法
 * </p>
 *
 * @author yangqc
 * @date Created in 2019-05-07
 * @modified By yangqc
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<Integer> callable = () -> {
            Thread.sleep(2000);
            return 1;
        };
        //submit一个Callable，其实就是执行的是FutureTask，而FutureTask继承自Callable以及Runnable
        Future<Integer> future = executorService.submit(callable);
        future.cancel(false);
        System.out.println(future.get());
    }
}
