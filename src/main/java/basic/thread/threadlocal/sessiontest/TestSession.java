package basic.thread.threadlocal.sessiontest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-05-08
 * @modified By yangqc
 */
public class TestSession {

    public static void main(String[] args) {
        /**
         * 这里核心线程池为0，先把任务放在队列里面，然后再去判断线程池是否关闭，如果没有关闭，那么则再去判断
         * 当前运行线程池数量是否为空，如果为空，那么新建一个worker，当前worker的firstTask为空，worker运行起来后，
         * 还是会去阻塞队列里面获取任务，获取到任务后就执行该任务
         */
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 5, 60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), new CustomThreadFactory());
        MySession mySession = new MySession(12, "qicheng");
        executorService.execute(() -> {
            new SessionSet().setSession(mySession);
            MySession session = getSession();
            System.out.println(Thread.currentThread().getName() + ",session is:" + session);
        });
        executorService.shutdown();
    }

    private static MySession getSession() {
        return MySessionUtil.getSession();
    }


}

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

class SessionSet {

    public void setSession(MySession session) {
        MySessionUtil.setSession(session);
    }
}
