package basic.collection.queue;

import java.lang.reflect.InvocationTargetException;
import java.util.Queue;

public class QueueBehavior {
    private static int count = 10;

    static <T> void test(Queue<T> queue, Class<T> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        for (int i = 0; i < count; i++) {
            queue.offer(clazz.getConstructor(String.class).newInstance("hello" + i));
        }
        while (queue.peek() != null) {
            System.out.println(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
