package basic.math.mathtest;

/*
 * ��Ա����
 * public static final double PI
 * public static final double E
 *
 * ��Ա����
 * public static int abs(int a);����ֵ
 * public static double ceil(double a)����ȡ��
 * public static double floor(double a)����ȡ֤
 * public static max(int a,int b)
 *
 * public static double pow(double a,double b) a��b����
 *
 * public static double random() �����
 * public static int round(float a) ��������
 *
 * public souble sqrt(double a)a����ƽ����
 */
public class MathDemo {

  public static void main(String[] args) {
    System.out.println("PI:" + Math.PI);
    System.out.println("E:" + Math.E);

    System.out.println("Random:" + Math.random());
    //��ȡһ��һ��һ��֮��������
    System.out.println("random:" + ((int) Math.random() * 100 + 1));
  }
}
