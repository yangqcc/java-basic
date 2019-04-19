package basic.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * <p>title:原子数组类型</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-04-12
 * @modified By yangqc
 */
public class AtomicIntegerArrayTest {

    public static void main(String[] args) {
        int itemValue = 0;
        int[] nums = {1, 2, 3, 4, 5, 6};
        AtomicIntegerArray i = new AtomicIntegerArray(nums);
        for (int j = 0; j < nums.length; j++) {
            System.out.println(i.get(j));
        }

        itemValue = i.getAndSet(0, 2);
        System.out.println("itemValue:" + itemValue + ";i:" + i);
        //指定位置原子性增加1
        itemValue = i.getAndIncrement(1);
        System.out.println("itemValue:" + itemValue + ";i:" + i);
        //指定位置增加指定值，返回指定位置之前的值
        itemValue = i.getAndAdd(0, 5);
        System.out.println("itemValue:" + itemValue + ";i:" + i);
    }
}
