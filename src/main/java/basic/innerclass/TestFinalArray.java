package basic.innerclass;

import java.util.Arrays;

/**
 * ����final���ε�����ɷ񱻸ı�
 *
 * @author yangqc 2016��9��19��
 */
public class TestFinalArray {

  private final Integer[] a;
  private Integer[] b;

  public TestFinalArray(Integer[] a) {
    this.a = a;
  }

  public void setB(Integer[] b) {
    this.b = b;
    System.out.println(Arrays.toString(b));
  }

  public void changeArray(int index, Integer currentValue) {
    if (index > a.length || index < 0) {
      throw new IllegalArgumentException();
    }
    a[index] = currentValue;
  }

  // �޷�ͨ������
  // public void setA(Integer[] a){
  // this.a=a;
  // }

  public static void main(String[] args) {
    Integer[] a = new Integer[10];
    for (int i = 0; i < 10; i++) {
      a[i] = i;
    }
    TestFinalArray test = new TestFinalArray(a);
    test.changeArray(0, 10);
    System.out.println(Arrays.toString(a));
    test.setB(a);
    test.setB(new Integer[]{1, 2, 3});
  }
}
