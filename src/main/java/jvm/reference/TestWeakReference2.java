package jvm.reference;

import java.lang.ref.WeakReference;

/**
 * 循环中,car一直在使用,所以weakCar没有被回收 2018/3/20
 *
 * @author yangqc
 */
public class TestWeakReference2 {

    public static void main(String[] args) {
        Car car = new Car(22000, "silver");
        WeakReference<Car> weakCar = new WeakReference<>(car);
        int i = 0;
        while (true) {
            System.out.println("here is the strong reference 'car' " + car);
            if (weakCar.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + " loops - " + weakCar);
            } else {
                System.out.println("Object has been collected.");
                break;
            }
        }
    }
}
