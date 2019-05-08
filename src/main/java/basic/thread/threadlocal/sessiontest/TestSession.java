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
