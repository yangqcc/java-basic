package basic.math.mathtest;

import java.util.Random;

/*
 * random�����������
 * ���췽��
 *
 *  public Random() û�����ӣ�Ĭ�����ӣ���ǰʱ��ĺ���ֵ��
 *  public Random(long seed)  �����̶�������
 *
 *  �������Ӻ�ÿ�ε��ĵ����������ͬ��
 *  û�����ӣ�������ǲ�ͬ��
 *
 *  ���Ӳ�һ��������һ����ʲô����
 *
 *  public int nextInt  ���ص���int��Χ�ڵ������
 *  public int nextInt(int n) ����[0,N)��Χ�ڵ������
 */
public class RandomDemo {

  public static void main(String[] args) {
//		Random r=new Random();
    Random r = new Random(111);
    for (int x = 0; x < 10; x++) {
      int num = r.nextInt(100);
      System.out.println(num);
    }
  }
}
