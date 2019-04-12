package basic.thread.printNumber;

/**
 * ����3���̴߳�ӡ����������, �߳�1�ȴ�ӡ1,2,3,4,5, Ȼ�����߳�2��ӡ6,7,8,9,10, Ȼ�����߳�3��ӡ11,12,13,14,15.
 * ���������߳�1��ӡ16,17,18,19,20....�Դ�����, ֱ����ӡ��75. �����������Ӧ��Ϊ:
 *
 * �˷������ü���
 *
 * @author yangqc
 */
public class PrintNumber3 {

  private static final int THREAD_NUMBER = 3;
  private static final int MAX_NUMBER = 1111;
  private static final int RUN_TIMES = 5;
  private static volatile int flag = 0;
  private static volatile int state = MAX_NUMBER / RUN_TIMES + 1;

  static class Task implements Runnable {

    private final int id;

    public Task(int id) {
      this.id = id;
    }

    @Override
    public void run() {
      while (flag < MAX_NUMBER && state > 0) {
        if (state % THREAD_NUMBER == id) {
          for (int i = 0; i < RUN_TIMES && flag < MAX_NUMBER; i++) {
            System.out.println(Thread.currentThread().getName() + " * " + ++flag);
          }
          state--;
        }
      }
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < THREAD_NUMBER; i++) {
      new Thread(new PrintNumber3.Task(i)).start();
    }
  }
}
