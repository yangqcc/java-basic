package basic.math.biginteger;

import java.math.BigInteger;

/*
 * public BigInteger add(BigInteger val); ��
 * public BigInteger subtract(BigInteger val); ��
 * public BigInteger multiply(BigInteger val); ��
 * public BigInteger divide(BigInteger val); ��
 * public BigInteger[] divideAndRemainder(BigInteger val)
 * �����̺�����������
 * 2015.10.2
 */
public class BigIntegerDemo2 {

  public static void main(String[] args) {
    BigInteger big1 = new BigInteger("100");
    BigInteger big2 = new BigInteger("90");

    System.out.println("add:" + big1.add(big2));
    System.out.println("dubtract:" + big1.subtract(big2));
    System.out.println("multiple:" + big1.multiply(big2));
    System.out.println("divide:" + big1.divide(big2)); //����ֻ����

    BigInteger[] bis = big1.divideAndRemainder(big2);
    System.out.println("��:" + bis[0]);
    System.out.println("����:" + bis[1]);
  }
}
