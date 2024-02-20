package basic.thread.lock.customLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-05-08
 * @modified By yangqc
 */
public class MyLockTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyLock myLock = new MyLock();
        Task task1 = new Task(myLock);
        Task task2 = new Task(myLock);
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.shutdown();
    }
}

class Task implements Runnable {

    private MyLock myLock;

    public Task(MyLock myLock) {
        this.myLock = myLock;
    }

    @Override
    public void run() {
        myLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ",获取到锁,开始睡觉!");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + ",睡醒了,释放锁!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            myLock.unlock();
        }
    }
}
