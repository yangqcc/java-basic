package com.yqc.thread.testThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal中有一个ThreadLocalMap,ThreadLocalMap里面持有一个数组对象,
 * 对象是Entry(key,value),其中Entry中的key就是当前ThreadLocal对象,在第一次执行set方法
 * 或者get()方法时,会把ThreadLocalMap赋值给Thread对象。
 * 
 * public T get() { Thread t = Thread.currentThread(); ThreadLocalMap map =
 * getMap(t); if (map != null) { ThreadLocalMap.Entry e = map.getEntry(this); if
 * (e != null) { @SuppressWarnings("unchecked") T result = (T)e.value; return
 * result; } } return setInitialValue(); }
 * 
 * 
 * private T setInitialValue() { T value = initialValue(); Thread t =
 * Thread.currentThread(); ThreadLocalMap map = getMap(t); if (map != null)
 * map.set(this, value); else createMap(t, value); return value; }
 * 
 * 
 * @author yangqc
 *
 */
public class TestThreadLocal {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new MyTask(1));
		exec.execute(new MyTask(2));
		exec.execute(new MyTask(3));
		exec.execute(new MyTask(4));
	}
}

class MyTask implements Runnable {
	private ThreadLocal<Integer> currentValue;

	MyTask(final int initValue) {
		currentValue = new ThreadLocal<Integer>() {
			protected Integer initialValue() {
				return initValue;
			}
		};
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				break;
			}
			System.out.println(Thread.currentThread().getName() + " : " + currentValue.get());
			currentValue.set(currentValue.get() + 1);
		}
	}
}