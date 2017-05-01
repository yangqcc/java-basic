package com.yqc.thread.concurrentQueue;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 简单实现阻塞队列
 * @author yangqc
 * 2016年12月20日
 * @param <T>
 */
public class MyArrayListQueue<T> {
	private ReentrantLock lock = new ReentrantLock();
	private Object[] objs;
	private int sum;
	private volatile int count = 0;
	private volatile int putIndex = 0;
	private volatile int getIndex = 0;
	private Condition putCondition = lock.newCondition();
	private Condition getCondition = lock.newCondition();

	public MyArrayListQueue(int sum) {
		this.sum = sum;
		objs = new Object[sum];
	}

	public void put(T t) {
		lock.lock();
		try {
			while (count == sum) {
				putCondition.await();
			}
			objs[putIndex] = t;
			if (++putIndex == sum) {
				putIndex = 0;
			}
			count++;
			getCondition.signalAll();
			System.out.println("put" + Arrays.toString(objs));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	@SuppressWarnings("all")
	public T get() {
		T t = null;
		lock.lock();
		try {
			while (count == 0) {
				getCondition.await();
			}
			t = (T) objs[getIndex];
			objs[getIndex] = null;
			if (++getIndex == sum) {
				getIndex = 0;
			}
			count--;
			putCondition.signalAll();
			System.out.println("get" + Arrays.toString(objs));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return t;
	}

	public static void main(String[] args) {
		MyArrayListQueue<Integer> queue = new MyArrayListQueue<>(3);
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
