package com.yqc.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试SoftReference
 * 在内存将要被分配完时,开始回收SoftReference,如果内存还不够用，那么抛出OutOfMemoryError
 *
 * @author yangqc 2016年12月21日
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
