package com.yqc.printNumber;

/**
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15.
 * 接着再由线程1打印16,17,18,19,20....以此类推, 直到打印到75. 程序的输出结果应该为:
 * 
 * 此方法不用加锁
 * 
 * @author yangqc
 *
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
			while (true && flag < MAX_NUMBER && state > 0) {
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
