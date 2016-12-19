package com.yqc.testThread.lock;

public class MyLock {
	private volatile boolean flag = false;
	private Thread currentThread;

	public synchronized void lock() throws InterruptedException {
		
		while(flag){
			wait();
		}
	}
}
