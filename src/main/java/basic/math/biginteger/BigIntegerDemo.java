package basic.math.biginteger;

import java.math.BigInteger;

/*
 * BigInteger�����ó���Integer��Χ�ڵ����ݽ�������
 * BigInteger(String val);
 *
 * 2015.10.2
 */
public class BigIntegerDemo {

  public static void main(String[] args) {
    Integer i = new Integer(100);
    String s = "189";
    Integer iiii = new Integer(s);
    System.out.println(Integer.MAX_VALUE);
    Integer ii = new Integer(2147483647);//2147483647 Integer��ʾ�����Χ
    System.out.println(ii);
//		Integer iii=new Integer(2147483648);

    BigInteger bi = new BigInteger("2147483648");
    System.out.println("bi:" + bi);
  }
}
