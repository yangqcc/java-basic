package basic.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadLocalTest {

  private static final ExecutorService executorService = Executors.newCachedThreadPool();

  public static void main(String[] args) {
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 10);
    for (int i = 0; i < 100; i++) {
      new Thread(() -> {
        threadLocal.set(Integer.valueOf("10"));
        System.out.println(threadLocal.get());
      }).start();
    }
    executorService.submit(() -> {
      ThreadLocal<Integer> tl = ThreadLocal.withInitial(() -> 10);//这里可能造成内存泄漏，线程执行完了，ThreadLocal会被清除，但是没有从当前删除，可能value就会一直保存在Thread里面
      tl.set(10);
      System.out.println(tl.get());
    });
    System.out.println("main thread is done!");
  }

  public static final class ThreadLocalUtil {

    private static final ThreadLocal<Map<String, Object>> local = new ThreadLocal<>();

    public static Object getValue(String key) {
      Map<String, Object> map = local.get();
      return map.get(key);
    }

    public static Map<String, Object> getValue() {
      return local.get();
    }

    public static void setValue(String key, Object value) {
      Map<String, Object> map = local.get();
      if (map == null) {
        map = new HashMap<>();
      }
      map.put(key, value);
      local.set(map);
    }

    public static void clear() {
      local.remove();
    }
  }
}
