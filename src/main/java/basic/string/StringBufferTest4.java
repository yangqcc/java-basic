package basic.string;

import java.util.Scanner;

/**
 * �ж��ַ����Ƿ�Գ�
 *
 * @author yangqc
 */
public class StringBufferTest4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String s = sc.nextLine();
        System.out.println(judge2(s));
    }

    public static boolean judge2(String s) {
        return new StringBuffer(s).reverse().toString().equals(s);
    }

    public static boolean judge(String s) {
        String s1 = null;
        String s2 = null;
        if (s.length() % 2 == 0) {
            s1 = s.substring(0, s.length() / 2);
            s2 = s.substring(s.length() / 2);
        } else {
            s1 = s.substring(0, s.length() / 2);
            s2 = s.substring((s.length() / 2) + 1);
        }
        return s1.equals(s2);
    }
}
