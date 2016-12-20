package com.yqc.testThread.concurrentQueue;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 信号量实现阻塞队列
 * 
 * @author yangqc 2016年12月20日
 * @param <T>
 */
public class MyArrayListQueue2<T> {
	private int sum;
	private Object[] objs;
	private ReentrantLock lock;
	private Semaphore putSemaphore;
	private Semaphore getSemaphore;
	private volatile int putIndex = 0;
	private volatile int getIndex = 0;

	public MyArrayListQueue2(int sum) {
		this.sum = sum;
		objs = new Object[sum];
		putSemaphore = new Semaphore(sum);
		getSemaphore = new Semaphore(0);
		lock = new ReentrantLock();
	}

	public void put(T t) {
		try {
			putSemaphore.acquire();
			lock.lock();
			objs[putIndex] = t;
			if (++putIndex == sum) {
				putIndex = 0;
			}
			getSemaphore.release();
			System.out.println("put:" + Arrays.toString(objs));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	@SuppressWarnings("all")
	public T get() {
		T t = null;
		try {
			getSemaphore.acquire();
			lock.lock();
			t = (T) objs[getIndex];
			objs[getIndex] = null;
			if (++getIndex == sum) {
				getIndex = 0;
			}
			putSemaphore.release();
			System.out.println("get:" + Arrays.toString(objs));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return t;
	}

	public static void main(String[] args) {
		MyArrayListQueue2<Integer> queue = new MyArrayListQueue2<>(3);
		Runnable putTask = new Runnable() {

			@Override
			public void run() {
				while (true) {
					queue.put(1);
				}
			}
		};
		Runnable getTask = new Runnable() {

			@Override
			public void run() {
				while (true) {
					queue.get();
				}
			}
		};

		ExecutorService exec = Executors.newCachedThreadPool();
		exec.submit(putTask);
		exec.submit(putTask);
		exec.submit(putTask);
		exec.submit(getTask);
		exec.submit(getTask);
		exec.submit(getTask);
	}
}
