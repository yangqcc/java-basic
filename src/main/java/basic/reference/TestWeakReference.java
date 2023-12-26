package basic.reference;

import java.lang.ref.WeakReference;
/**
 * ����WeakReference,��û��ǿ����ָ��ö���ʱ,��ô�ö������´���������ʱ������
 * @author yangqc
 * 2016��12��21��
 */
public class TestWeakReference {
	public static void main(String[] args) {
		Car car = new Car(20000, "silver");
		WeakReference<Car> weakCar = new WeakReference<Car>(car);
		int i = 0;
		while (true) {
			System.out.println("here is the strong reference 'car'" + car);
			if (weakCar.get() != null) {
				i++;
				System.out.println("Object is alive for" + i + "loops - " + weakCar);
				if (i == 5) {
					car = null;
					System.gc();
				}
			} else {
				System.out.println("Object has bean collected , " + "and i = " + i);
				break;
			}
		}

	}
}

class Car {
	private int cost;
	private String name;

	Car(int cost, String name) {
		this.cost = cost;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [cost=" + cost + ", name=" + name + "]";
	}

}