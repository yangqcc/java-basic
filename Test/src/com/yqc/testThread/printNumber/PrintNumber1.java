package com.yqc.testThread.printNumber;

/**
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15.
 * 接着再由线程1打印16,17,18,19,20....以此类推, 直到打印到75
 * 
 * @author yangqc
 *
 */
public class PrintNumber1 {
	private static volatile int state = 1;
	private static final int MAX_NUMBER = 75;
	private static volatile int flag = 0;

	public static void main(String[] args) {
		PrintNumber1 printNumber1 = new PrintNumber1();

		Runnable task1 = new Runnable() {

			@Override
			public void run() {
				while (true && flag < MAX_NUMBER) {
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
			}
		};

		Runnable task2 = new Runnable() {

			@Override
			public void run() {
				while (true && flag < MAX_NUMBER) {
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
			}
		};

		Runnable task3 = new Runnable() {

			@Override
			public void run() {
				while (true && flag < MAX_NUMBER) {
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
			}
		};

		new Thread(task1).start();
		new Thread(task2).start();
		new Thread(task3).start();
	}
}
