/*
 * StringBuilder���������Ը��ӷ���
 * 2015.2.10
 */
package basic.string;

import java.util.Random;

/**
 * @author yangqc
 */
public class UsingStringBuilder {

    public static Random rand = new Random(47);

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        //删除指定位置指定长度
        result.delete(result.length() - 2, result.length());
        result.append("]");
        //返回String结果类型
        return result.toString();
    }

    public static void main(String[] args) {
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
    }
}
