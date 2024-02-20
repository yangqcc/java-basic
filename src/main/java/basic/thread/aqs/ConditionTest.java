package basic.thread.aqs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-04-13
 * @modified By yangqc
 */
public class ConditionTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition isEmptyCondition = lock.newCondition();
        Condition isFullCondition = lock.newCondition();
        ArrayList<Integer> list = new ArrayList<>();
        ExecutorService es = Executors.newCachedThreadPool();
        //  es.submit(new Producer(lock, isFullCondition, isEmptyCondition, list));
        //  es.submit(new Producer(lock, isFullCondition, isEmptyCondition, list));
        es.submit(new Producer(lock, isFullCondition, isEmptyCondition, list));
        es.submit(new Customer(lock, isFullCondition, isEmptyCondition, list));
        es.submit(new Customer(lock, isFullCondition, isEmptyCondition, list));
        es.submit(new Customer(lock, isFullCondition, isEmptyCondition, list));
        es.submit(new Customer(lock, isFullCondition, isEmptyCondition, list));
    }
}

class Producer implements Runnable {

    private final Lock lock;

    private final Condition isFullCondition;

    private final Condition isEmptyCondition;

    private final List<Integer> list;

    public Producer(Lock lock, Condition isFullCondition, Condition isEmptyCondition,
                    List<Integer> list) {
        this.lock = lock;
        this.isFullCondition = isFullCondition;
        this.isEmptyCondition = isEmptyCondition;
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //一秒钟产生一个产品
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                lock.lock();
                if (list.size() == 10) {
                    isFullCondition.await();
                }
                System.out.println("生产者线程'" + Thread.currentThread().getName() + "'生产产品!");
                list.add(2);
                isEmptyCondition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

class Customer implements Runnable {

    private final Lock lock;

    private final Condition isFullCondition;

    private final Condition isEmptyCondition;

    private final List<Integer> list;

    public Customer(Lock lock, Condition isFullCondition, Condition isEmptyCondition,
                    List<Integer> list) {
        this.lock = lock;
        this.isFullCondition = isFullCondition;
        this.isEmptyCondition = isEmptyCondition;
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //500毫秒消耗一个产品
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                lock.lock();
                if (list.size() == 0) {
                    System.out.println("线程'" + Thread.currentThread().getName() + "'等待condition！");
                    isEmptyCondition.await();
                }
                System.out.println("消费者线程'" + Thread.currentThread().getName() + "'消费产品，" + list.remove(0));
                isFullCondition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}