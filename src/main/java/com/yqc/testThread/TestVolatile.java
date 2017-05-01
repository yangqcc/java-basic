package com.yqc.testThread;

/**
 * 测试内存屏障
 * 
 * 如果不加volatile,success改变后,并没有写会主存中去,还是存在CPU的缓存中 当然，加上synchronized也可以
 * 
 * @author yangqc
 *
 */
public class TestVolatile {
	private boolean success = false;

	public void getResult() {
		while (true) {
			try {
				Thread.sleep(500);
				Thread.yield();
			} catch (InterruptedException e) {
				System.out.println("sorry!");
			}
			if (success) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
	}

	public void setSuccess() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.success = true;
		System.out.println("hello================");
	}

	public static void main(String[] args) throws InterruptedException {
		TestVolatile testVolatile = new TestVolatile();
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				testVolatile.setSuccess();
			}
		};

		Runnable task2 = new Runnable() {

			@Override
			public void run() {
				testVolatile.getResult();
			}
		};

		new Thread(task2).start();
		new Thread(task1).start();
		System.out.println("==");
	}
}
