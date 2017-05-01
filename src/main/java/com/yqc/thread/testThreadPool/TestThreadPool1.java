package com.yqc.thread.testThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool1 {
	volatile static int i = 0;

	public static void main(String[] args) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						if (Thread.interrupted()) {
							System.out.println("interrupted!");
						}
						if (i++ == 10000) {
							break;
						}
						Thread.sleep(1000);
						System.out.println("xixi");
					} catch (InterruptedException e) {
						System.out.println("我被中断了");
					}
				}
			}
		};

		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(task);
		exec.shutdown();
	}
}