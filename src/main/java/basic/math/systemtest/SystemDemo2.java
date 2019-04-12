package basic.math.systemtest;

/**
 * public static void exit(int status)��ֹjava�������0��ʾ�쳣��ֹ
 *
 * @author yangqc
 */
public class SystemDemo2 {

  public static void main(String[] args) {
//		System.out.println("����ϲ����!");
//		System.exit(0);//��ֹ��ǰ�������е������
//		System.out.println("�������ϲ����!");

    System.out.println(System.currentTimeMillis());//��ǰʱ��ĺ���ֵ
    //ͳ�Ƴ�������ʱ��
    long start = System.currentTimeMillis();
    for (int x = 0; x < 100000; x++) {
      System.out.println("hello" + x);
    }
    long end = System.currentTimeMillis();
    System.out.println("����ʱ��" + (end - start) + "����");
  }
}
