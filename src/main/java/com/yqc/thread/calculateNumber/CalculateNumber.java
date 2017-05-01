package com.yqc.thread.calculateNumber;

/**
 * 四个线程a,b,c,d. 线程a,b对变量i加一. 线程c,d对变量i减去一.四个线程顺序执行, 每个线程每次只执行一次. i的初始值为0， 打印结果0
 * 1 2 1 0 1 2 1 0 1 2...
 * 
 * @author yangqc
 *
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
			while (state < MAX_COUNT)
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

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			new Thread(new CalculateNumber.Task(i)).start();
		}
	}
}
