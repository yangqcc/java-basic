package com.yqc.printNumber;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumber2 {
	private static volatile int state = 1;
	private static final int MAX_NUMBER = 75;
	private static int flag = 0;

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();
		Condition condition3 = lock.newCondition();
		Runnable task1 = new Runnable() {

			@Override
			public void run() {
				while (true && flag < MAX_NUMBER) {
					lock.lock();
					try {
						if (state == 1) {
							for (int i = 0; i < 5 && flag<MAX_NUMBER; i++) {
								System.out.println(Thread.currentThread().getName() + " * " + ++flag);
							}
							state = 2;
							condition2.signal();
						} else {
							try {
								condition1.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
								break;
							}
						}
						condition2.signal();  //程序结束线程2可能还阻塞在那里
					} finally {
						lock.unlock();
					}
				}
			}
		};

		Runnable task2 = new Runnable() {

			@Override
			public void run() {
				while (true && flag < MAX_NUMBER) {
					lock.lock();
					try {
						if (state == 2) {
							for (int i = 0; i < 5 && flag<MAX_NUMBER; i++) {
								System.out.println(Thread.currentThread().getName() + " * " + ++flag);
							}
							state = 3;
							condition3.signal();
						} else {
							try {
								condition2.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
								break;
							}
						}
						condition1.signal();
					} finally {
						lock.unlock();
					}
				}
			}
		};

		Runnable task3 = new Runnable() {

			@Override
			public void run() {
				while (true && flag < MAX_NUMBER) {
					lock.lock();
					try {
						if (state == 3) {
							for (int i = 0; i < 5 && flag<MAX_NUMBER; i++) {
								System.out.println(Thread.currentThread().getName() + " * " + ++flag);
							}
							state = 1;
							condition1.signal();
						} else {
							try {
								condition3.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
								break;
							}
						}
					} finally {
						lock.unlock();
					}
				}
			}
		};

		new Thread(task1).start();
		new Thread(task2).start();
		new Thread(task3).start();
	}
}
