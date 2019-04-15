package basic.time.date;

import java.util.Date;

/*
 * public long getTime() ��ȡʱ�䣬�Ժ���Ϊ��λ
 * public void setTime(long time) ����ʱ��
 *
 * ��Date�õ�����ֵ
 *
 * �Ѻ���ֵת��ΪDate
 *
 * 2015.10.6
 */
public class DateDemo2 {

  public static void main(String[] args) {
    Date d = new Date();
    long time = d.getTime();
    System.out.println(time);
//		System.out.println(System.currentTimeMillis());

    //����ʱ��
    System.out.println("d:" + d);
    d.setTime(100);
    System.out.println("d:" + d);//ע��ʱ��
  }
}
