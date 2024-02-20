package basic.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-05-08
 * @modified By yangqc
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        /**
         * 记住ArrayBlockingQueue构造器一定要指定容量，一旦设置，容量不会改变，这个和ArrayList不一样，ArrayList会自动扩容
         * 第二个参数是设置阻塞线程获取或者放置元素时是否以公平模式设置或者获取，默认为false
         */
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(2, true);
    }
}
