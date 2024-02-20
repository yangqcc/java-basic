package basic.reference;

import java.lang.ref.WeakReference;

/**
 * 测试WeakReference,当没有强引用指向该对象时,那么该对象在下次垃圾回收时被回收
 *
 * @author yangqc 2016年12月21日
 */
public class TestWeakReference {

  public static void main(String[] args) {
    Car car = new Car(20000, "silver");
    WeakReference<Car> weakCar = new WeakReference<>(car);
    int i = 0;
    while (true) {
      System.out.println("here is the strong reference 'car'" + car);
      if (weakCar.get() != null) {
        i++;
        System.out.println("Object is alive for" + i + "loops - " + weakCar);
        if (i == 5) {
          car = null;
          //进行垃圾回收
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