package basic.thread.printnumber;

/**
 * ����3���̴߳�ӡ����������, �߳�1�ȴ�ӡ1,2,3,4,5, Ȼ�����߳�2��ӡ6,7,8,9,10, Ȼ�����߳�3��ӡ11,12,13,14,15.
 * ���������߳�1��ӡ16,17,18,19,20....�Դ�����, ֱ����ӡ��75
 *
 * @author yangqc
 */
public class PrintNumber1 {

  private static volatile int state = 1;
  private static final int MAX_NUMBER = 75;
  private static volatile int flag = 0;

  public static void main(String[] args) {
    PrintNumber1 printNumber1 = new PrintNumber1();

    Runnable task1 = () -> {
      while (flag < MAX_NUMBER) {
        synchronized (printNumber1) {
          if (state == 1) {
            for (int i = 0; i < 5 && flag < MAX_NUMBER; i++) {
              System.out.println(Thread.currentThread().getName() + " * " + ++flag);
            }
            state = 2;
            printNumber1.notifyAll();
          } else {
            try {
              printNumber1.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
              break;
            }
          }
        }
      }
    };

    Runnable task2 = () -> {
      while (flag < MAX_NUMBER) {
        synchronized (printNumber1) {
          if (state == 2) {
            for (int i = 0; i < 5 && flag < MAX_NUMBER; i++) {
              System.out.println(Thread.currentThread().getName() + " * " + ++flag);
            }
            state = 3;
            printNumber1.notifyAll();
          } else {
            try {
              printNumber1.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
              break;
            }
          }
        }
      }
    };

    Runnable task3 = () -> {
      while (flag < MAX_NUMBER) {
        synchronized (printNumber1) {
          if (state == 3) {
            for (int i = 0; i < 5 && flag < MAX_NUMBER; i++) {
              System.out.println(Thread.currentThread().getName() + " * " + ++flag);
            }
            state = 1;
            printNumber1.notifyAll();
          } else {
            try {
              printNumber1.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
              break;
            }
          }
        }
      }
    };

    new Thread(task1).start();
    new Thread(task2).start();
    new Thread(task3).start();
  }
}
