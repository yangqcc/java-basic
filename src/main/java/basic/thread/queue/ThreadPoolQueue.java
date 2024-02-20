package basic.thread.queue;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-05-06
 * @modified By yangqc
 */
public class ThreadPoolQueue {

    public static void main(String[] args) {
        Executor cachePool = Executors.newCachedThreadPool();
    }
}
