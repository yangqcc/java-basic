package basic.math.bigdecimal;

import java.math.BigDecimal;

/*
 * BigDecimal
 * �����������ʱ��float���ͺ�double���ͺ����׶�ʧ���ȣ�����Ϊ���ܾ�ȷ�ı�ʾ�����㸡����
 * java�ṩ��BigDecimal
 *
 * BigDecimal�����
 * ���ɱ�ģ����⾫�ȵ��з���ʮ������
 *
 * ���췽��
 * public BigDecimal(String val);
 *
 * ���Խ����Ϊ�������ݶ�ʧ����
 *
 * 2015.10.2
 */
public class BigDecimalDemo1 {

  public static void main(String[] args) {
    //ע������Ľ�� float �� double����
    System.out.println(0.09 + 0.01);
    System.out.println(1.0 - 0.32);
    System.out.println(1.015 * 100);
    System.out.println(1.301 / 100);

    System.out.println(1.0 - 0.12);

    BigDecimal bd1 = new BigDecimal("0.09");
    BigDecimal bd2 = new BigDecimal("0.01");
    System.out.println(bd1.add(bd2));
  }
}
