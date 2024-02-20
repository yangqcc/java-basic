package basic.thread.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-05-08
 * @modified By yangqc
 */
class CustomThreadFactory implements ThreadFactory {
    private static AtomicInteger count = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("thread-pool-" + count.get());
        count.getAndAdd(1);
        return thread;
    }
}

