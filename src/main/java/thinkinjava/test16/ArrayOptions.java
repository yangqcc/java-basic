package thinkinjava.test16;

import java.util.Arrays;

/**
 * ���ִ�������Ķ���ķ�ʽ����ס��a[] v=new a[]{}���ַ�ʽ��ʾ������һ������Ϊ0���������
 * 1.���������д洢���Ƕ�������� 2.�������������д�ŵ��ǻ������͵���ֵ 3.�������û�г�ʼ�����䱣��Ķ����Զ���ʼ��null��int,char�Զ���ʼ��Ϊ0��boolean��ʼ��Ϊfalse
 * 2015.8.31
 */
public class ArrayOptions {

  public static void main(String[] args) {
    BerylliumSphere[] a;
    BerylliumSphere[] e = new BerylliumSphere[]{};//�����ʾ������һ��������󣬵������鳤��Ϊ0������������������
    BerylliumSphere[] b = new BerylliumSphere[5];
    System.out.println("b: " + Arrays.toString(b));
    BerylliumSphere[] c = new BerylliumSphere[4];
    for (int i = 0; i < c.length; i++) {
      if (c[i] == null) {
        c[i] = new BerylliumSphere();
      }
    }
    BerylliumSphere[] d = {new BerylliumSphere(), new BerylliumSphere(),
        new BerylliumSphere()};//��������ͨ�ۼ�����ʼ��ʽ����ʽ���ڶ����洴����һ���������

    a = new BerylliumSphere[]{new BerylliumSphere(),
        new BerylliumSphere()};

//		for(int i=0;i<100;i++){
//			e[i]=new BerylliumSphere();
//		}
    System.out.println("a.length= " + a.length);
    System.out.println("b.length= " + b.length);
    System.out.println("c.length= " + c.length);
    System.out.println("d.length= " + d.length);
    System.out.println("e.length= " + e.length);
    a = d;
    System.out.println("a.length= " + a.length);
  }
}
