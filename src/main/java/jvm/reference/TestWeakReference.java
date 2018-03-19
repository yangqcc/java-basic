package jvm.reference;

import java.lang.ref.WeakReference;

/**
 * 循环中,car没有被使用,所以WeakReference会在某个时间节点被回收
 *
 * @author yangqc
 */
public class TestWeakReference {
    public static void main(String[] args) {
        Car car = new Car(22000, "silver");
        WeakReference weakCar = new WeakReference(car);
        int i = 0;
        while (true) {
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
