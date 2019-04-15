package basic.time.date;

import java.util.Date;

/**
 * public long getTime() 获取毫秒
 * public void setTime(long time) 设置毫秒时间
 *
 * ��Date�õ�����ֵ
 *
 * �Ѻ���ֵת��ΪDate
 *
 * 2015.10.6
 *
 * @author yangqc
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
