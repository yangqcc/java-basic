package basic.thread;

/**
 * �����ڴ�����
 * 
 * �������volatile,success�ı��,��û��д��������ȥ,���Ǵ���CPU�Ļ����� ��Ȼ������synchronizedҲ����
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
