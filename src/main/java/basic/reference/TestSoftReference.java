package basic.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * ����SoftReference
 * ���ڴ潫Ҫ��������ʱ,��ʼ����SoftReference,����ڴ滹�����ã���ô�׳�OutOfMemoryError
 *
 * @author yangqc 2016��12��21��
 */
public class TestSoftReference {
    public static void main(String[] args) {
        int[] mb = new int[1024 * 1024 * 10];
        List<int[]> list = new ArrayList<>();
        Car car = new Car(123, "benz");
        SoftReference<Car> softCar = new SoftReference<>(car);
        int i = 0;
        while (true) {
            list.add(new int[1024 * 1024 * 10]);
            i++;
            if (softCar.get() != null) {
                System.out.println("softCar is alive!");
            } else {
                System.out.println("softCar is dead!");
                System.out.println(car == softCar.get());
//				break;
            }
            if (i == 10) {
                car = null;
                System.gc();
            }
        }
    }
}
