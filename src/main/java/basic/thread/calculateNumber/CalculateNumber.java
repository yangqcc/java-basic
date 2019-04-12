package basic.thread.calculateNumber;

/**
 * �ĸ��߳�a,b,c,d. �߳�a,b�Ա���i��һ. �߳�c,d�Ա���i��ȥһ.�ĸ��߳�˳��ִ��, ÿ���߳�ÿ��ִֻ��һ��. i�ĳ�ʼֵΪ0��
 * ��ӡ���0 1 2 1 0 1 2 1 0 1 2...
 *
 * @author yangqc
 */
public class CalculateNumber {

  private static volatile int number = 0;
  private static volatile int state = 0;
  private static final int THREAD_COUNT = 6;
  private static final int MAX_COUNT = 150;
  private static final int SPLIT = (THREAD_COUNT + 1) / 2;

  static class Task implements Runnable {

    private final int id;

    public Task(int id) {
      this.id = id;
    }

    @Override
    public void run() {
      while (state < MAX_COUNT) {
        if (state % THREAD_COUNT == id) {
          if (id < SPLIT) {
            number++;
          } else {
            number--;
          }
          System.out.println(Thread.currentThread().getName() + " * " + number);
          state++;
        }
      }
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < THREAD_COUNT; i++) {
      new Thread(new CalculateNumber.Task(i)).start();
    }
  }
}
