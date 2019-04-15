package basic.generic;

import java.util.Collection;
import java.util.Date;
import java.util.Vector;

/**
 * ���ͺ���
 *
 * 2015.10.20
 *
 * @author yangqc
 */
public class GenericDemo2 {

  public static void main(String[] args) {
    //��ʵ��û������
    //�����ƶϣ�����ǽ���

    //�Զ�װ��
    add(2, 4);
    add(2, "adfs");//���꣬������Ҳ��
    Number x = add(2, 3.4);//�����軹�ǿ���
    Object a = add(2, "dsda");//�������֣�Object

    swap(new String[]{"21121", "dewdwe", "dewdew"}, 1, 1);
    //���ﱨ���ˣ����͵�����ֻ�����������ͣ�����ʹ��������
//		swap(new int[]{1,2,3,4,5},2,3);   //��������ᱨ��

    //һ��
    String s = autoConvert(1);

    copy1(new Vector<String>(), new String[10]);
    copy2(new Date[10], new String[10]); //�����ƶϣ��ܸ��ӵ�һ������
//		copy1(new Date[10],new Date[10]);    //ע������Ĵ���
  }


  private static <T> T add(T x, T y) {
    return y;
  }

  //��������������Ԫ�ص�λ��
  private static <T> void swap(T[] a, int i, int j) {
    T temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  private static <T> T autoConvert(Object obj) {
    return (T) obj;
  }

  private static <T> void fillArray(T[] a, T obj) {
    for (int i = 0; i < a.length; i++) {
      a[i] = obj;
    }
  }

  private static <T> void copy1(Collection<T> dest, T[] src) {
  }

  private static <T> void copy2(T[] dest, T[] src) {

  }
}
