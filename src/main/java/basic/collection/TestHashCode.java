package basic.collection;

import java.util.HashMap;

/**
 * ����HashCode��equals����,��дequals�����ͱ�����дhashCode����,
 * ��Ϊ�涨equals�����ôhashCode�ͱ������,��Ȼ�Ļ�HashTable��HashMap���������
 *
 * @author yangqc
 * 2016��12��22��
 */
public class TestHashCode {
    public static void main(String[] args) {
        HashMap<Car, Object> map = new HashMap<>();
        Car car1 = new Car("Benz", 120);
        Car car2 = new Car("Benz", 120);
        System.out.println(car1.equals(car2));
        System.out.println(car1.equals(car2));
        System.out.println(car1.hashCode() == car2.hashCode());
        map.put(car1, 12);
        map.put(car2, 13);
        System.out.println(map.get(car2));
        System.out.println(map.get(car1));
    }
}

class Car {
    private String name;
    private int cost;

    public Car(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cost;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (cost != other.cost)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}